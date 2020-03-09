import controller.ItemController;
import dao.IItemDAO;
import dto.ItemDTO;
import dto.exceptions.IdAlreadyInUseException;
import dto.exceptions.ItemNotAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemControllerTest {

    private static final String TEXT_ITEMS = "bread, butter";
    private static final int ITEM_ID = 1;
    private static final int HTTP_OK = 200;
    private static final int HTTP_CREATED = 201;

    private ItemController sut;
    private IItemDAO mockedItemDAO;

    @BeforeEach
    void setup() {
        this.sut = new ItemController();

        this.mockedItemDAO = mock(IItemDAO.class);

        this.sut.setItemDAO(mockedItemDAO);
    }

    @Test
    void getTextItemsReturnsTextItems() {
        // Arrange

        // Act
        var textItems = sut.getTextItems();

        // Assert
        assertEquals(TEXT_ITEMS, textItems);
    }

    @Test
    void getJsonReturnsObjectFromServiceAsEntity() {
        // Arrange
        var itemsToReturn = new ArrayList<ItemDTO>();
        when(mockedItemDAO.getAll()).thenReturn(itemsToReturn);

        // Act
        var response = sut.getJsonItems();

        // Assert
        assertEquals(HTTP_OK, response.getStatus());
        assertEquals(itemsToReturn, response.getEntity());
    }

    @Test
    void getJsonItemsCallsGetAll() {
        // Arrange

        // Act
        sut.getJsonItems();

        // Assert
        verify(mockedItemDAO).getAll();
    }

    @Test
    void addItemsCallsaAddItemOnService() {
        // Arrange
        var item = new ItemDTO(37, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");

        // Act
        sut.addItem(item);

        // Assert
        verify(mockedItemDAO).addItem(item);
    }

    @Test
    void addItemsReturnsHttp201() {
        // Arrange
        var item = new ItemDTO(37, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");

        // Act
        var response = sut.addItem(item);

        // Assert
        assertEquals(HTTP_CREATED, response.getStatus());
    }

    @Test
    void addItemsLetsIdAlreadyInUseExceptionPass() {
        // Arrange
        var item = new ItemDTO(37, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        doThrow(IdAlreadyInUseException.class).when(mockedItemDAO).addItem(item);

        // Act & Assert
        assertThrows(IdAlreadyInUseException.class, () -> sut.addItem(item));
    }

    @Test
    void getItemCallsGetItemOnService() {
        // Arrange
        var item = new ItemDTO(ITEM_ID, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");

        // Act
        sut.getItem(ITEM_ID);

        // Assert
        verify(mockedItemDAO).getItem(ITEM_ID);
    }

    @Test
    void getItemReturnsObjectFromServiceAsEntity() {
        // Arrange
        var item = new ItemDTO(ITEM_ID, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        when(mockedItemDAO.getItem(ITEM_ID)).thenReturn(item);

        // Act
        Response response = sut.getItem(ITEM_ID);

        // Assert
        assertEquals(item, response.getEntity());
    }

    @Test
    void getItemReturnsHttp200() {
        // Arrange
        var item = new ItemDTO(ITEM_ID, "Chocolate spread", new String[]{"Breakfast, Lunch"}, "Not to much");
        when(mockedItemDAO.getItem(ITEM_ID)).thenReturn(item);

        // Act
        Response response = sut.getItem(ITEM_ID);

        // Assert
        assertEquals(HTTP_OK, response.getStatus());
    }

    @Test
    void getItemLetsItemNotAvailableExceptionPass() {
        // Arrange
        doThrow(ItemNotAvailableException.class).when(mockedItemDAO).getItem(ITEM_ID);

        // Act & Assert
        assertThrows(ItemNotAvailableException.class, () -> sut.getItem(ITEM_ID));
    }

    @Test
    void deleteItemCallsDeleteItemOnService() {
        // Arrange

        // Act
        sut.deleteItem(ITEM_ID);

        // Assert
        verify(mockedItemDAO).deleteItem(ITEM_ID);
    }

    @Test
    void deleteItemsReturnsHttp200() {
        // Arrange

        // Act
        var response = sut.deleteItem(ITEM_ID);

        // Assert
        assertEquals(HTTP_OK, response.getStatus());
    }

    @Test
    void deleteItemLetsItemNotAvailableExceptionPass() {
        // Arrange
        doThrow(ItemNotAvailableException.class).when(mockedItemDAO).deleteItem(ITEM_ID);

        // Act & Assert
        assertThrows(ItemNotAvailableException.class, () -> sut.deleteItem(ITEM_ID));
    }
}