package nl.han.ica.oose.dea;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String writeOrders() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        return writeOrder(sb);
    }

    private String writeOrder(StringBuffer sb) {
        int ordersCount = orders.getOrdersCount();

        for (int i = 0; i < ordersCount; i++) {
            Order order = writeHeader(sb, i);
            writeProduct(sb, order);
            writeFooter(sb, order);
        }

        if (ordersCount > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private Order writeHeader(StringBuffer sb, int i) {
        Order order = orders.getOrder(i);
        sb.append("{" + "\"id\": ").append(order.getOrderId()).append(", ").append("\"products\": [");
        return order;
    }

    private void writeProduct(StringBuffer sb, Order order) {
        for (int j = 0; j < order.getProductsCount(); j++) {
            Product product = order.getProduct(j);

            sb.append("{" + "\"code\": \"")
                    .append(product.getCode())
                    .append("\", ")
                    .append("\"color\": \"")
                    .append(product.getColor())
                    .append("\", ");

            if (product.getSize() != -1) {
                sb.append("\"size\": \"");
                sb.append(product.determineSize());
                sb.append("\", ");
            }

            sb.append("\"price\": ")
                    .append(product.getPrice())
                    .append(", ")
                    .append("\"currency\": \"")
                    .append(product.getCurrency())
                    .append("\"}, ");
        }
    }

    private void writeFooter(StringBuffer sb, Order order) {
        if (order.getProductsCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
        sb.append("}, ");
    }
}
