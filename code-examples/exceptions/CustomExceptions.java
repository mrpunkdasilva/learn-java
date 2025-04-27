public class CustomExceptions {
    // Exceção verificada personalizada
    public class BusinessException extends Exception {
        public BusinessException(String message) {
            super(message);
        }

        public BusinessException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // Exceção não verificada personalizada
    public class ValidationException extends RuntimeException {
        private final String fieldName;
        
        public ValidationException(String fieldName, String message) {
            super(message);
            this.fieldName = fieldName;
        }

        public String getFieldName() {
            return fieldName;
        }
    }

    // Exceção com dados adicionais
    public class OrderProcessingException extends Exception {
        private final String orderId;
        private final OrderStatus status;

        public OrderProcessingException(String message, String orderId, 
                                     OrderStatus status, Throwable cause) {
            super(message, cause);
            this.orderId = orderId;
            this.status = status;
        }

        public String getOrderId() { return orderId; }
        public OrderStatus getStatus() { return status; }
    }

    // Exemplo de uso
    public void processOrder(Order order) throws OrderProcessingException {
        try {
            validateOrder(order);
            // Processamento do pedido
        } catch (ValidationException e) {
            throw new OrderProcessingException(
                "Failed to process order",
                order.getId(),
                OrderStatus.FAILED,
                e
            );
        }
    }
}