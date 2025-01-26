package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com os dados do cliente: ");
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de aniversario (DD/MM/YYYY): ");
        Date birthDate = sdf1.parse(sc.next());
        Client client = new Client(name, email, birthDate);

        System.out.println("Dados do pedido:");
        System.out.println("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("Quantos itens estão no pedido? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            System.out.println("Dados do #" + i + " item: ");
            System.out.print("Nome do item: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Preço do item: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantidade: ");
            int productquantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productquantity, productPrice, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("Recibo: ");
        System.out.println(order);

        sc.close();
    }
}
