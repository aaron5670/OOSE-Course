package dao;

import dto.ItemDTO;
import dto.exceptions.IdAlreadyInUseException;
import dto.exceptions.ItemNotAvailableException;

import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Alternative
public class ItemExcelDAO implements IItemDAO {
    private List<ItemDTO> items = new ArrayList<>();

    public ItemExcelDAO() {
        items.add(new ItemDTO(1, "Bread", new String[]{"Excel", "Lunch"}, "Delicious!"));
        items.add(new ItemDTO(2, "Butter", new String[]{"Excel", "Lunch"}, "Use it with bread"));
        items.add(new ItemDTO(3, "Honey", new String[]{"Excel", "Lunch"}, "Use it with bread"));
    }

    @Override
    public List<ItemDTO> getAll() {
        return items;
    }

    @Override
    public void addItem(ItemDTO itemDTO) {
        if (items.stream().anyMatch(item -> item.getId() == itemDTO.getId())) {
            throw new IdAlreadyInUseException();
        }

        items.add(itemDTO);
    }

    @Override
    public ItemDTO getItem(int id) {
        Optional<ItemDTO> requestedItem = items.stream().filter(item -> item.getId() == id).findFirst();

        if (requestedItem.isPresent()) {
            return requestedItem.get();
        } else {
            throw new ItemNotAvailableException();
        }
    }

    @Override
    public void deleteItem(int id) {
        Optional<ItemDTO> itemForName = items.stream().filter(item -> item.getId() == id).findFirst();

        List<ItemDTO> filteredItems = items.stream().filter(item -> item.getId() != id).collect(Collectors.toList());

        if (filteredItems.size() == items.size()) {
            throw new ItemNotAvailableException();
        }

        items = filteredItems;
    }
}
