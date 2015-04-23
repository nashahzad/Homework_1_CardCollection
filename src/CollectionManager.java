/**
 * Nauman Shahzad
 * 109813732
 * Homework #1
 * Thursday: R04
 * Gustavo Poscidonio
 *
 * @author Nauman
 */
import java.util.Scanner;

public class CollectionManager
{

    public static void choice(CardCollection A, CardCollection B, String choice, Scanner userInput, char[] looper)
    {
        do {
            System.out.print("Select an operation:");
            looper[0] = userInput.nextLine().charAt(0);

            switch (Character.toUpperCase(looper[0]))
            {
                case 'A':
                    System.out.print("Enter a collection:");
                    choice = userInput.nextLine();
                    if (choice.charAt(0) == 'A') {
                        BaseballCard newCard = createCard(userInput);
                        System.out.print("Enter a position:");
                        int position = userInput.nextInt();

                        int loop = 0;
                        while (loop == 0) {
                            try {
                                A.addCard(newCard, position);
                                loop = -1;
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                                position = userInput.nextInt();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                                loop = -1;
                            }
                        }
                    } else {
                        BaseballCard newCard = createCard(userInput);
                        System.out.print("Enter a position:");
                        int position = userInput.nextInt();

                        int loop = 0;
                        while (loop == 0) {
                            try {
                                B.addCard(newCard, position);
                                loop = -1;
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                                position = userInput.nextInt();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                                loop = -1;
                            }
                        }
                    }

                    break;

                case 'C':
                    System.out.print("Enter collection to copy from");
                    choice = userInput.nextLine();

                    System.out.print("Enter position of card to copy from:");
                    int position = userInput.nextInt();

                    if (choice.charAt(0) == 'A') {
                        System.out.print("Enter the collection to copy to:");
                        choice = userInput.nextLine();

                        if (choice.charAt(0) == 'A') {
                            try {
                                A.addCard(A.getCard(position), position);
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                                position = userInput.nextInt();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        } else {
                            try {
                                A.addCard(B.getCard(position), position);
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                                position = userInput.nextInt();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    } else {
                        System.out.print("Enter the collection to copy to:");
                        choice = userInput.nextLine();

                        if (choice.charAt(0) == 'A') {
                            try {
                                B.addCard(A.getCard(position), position);
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                                position = userInput.nextInt();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        } else {
                            try {
                                B.addCard(B.getCard(position), position);
                            } catch (IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                                position = userInput.nextInt();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }

                    break;

                case 'E':
                    System.out.print("Enter a collection:");
                    choice = userInput.nextLine();

                    System.out.print("Enter a position:");
                    position = userInput.nextInt();
                    System.out.print("Enter a price:");
                    double price = userInput.nextDouble();
                    while (price < 0) {
                        System.out.print("Price cannot be negative, try again: ");
                        price = userInput.nextDouble();
                    }

                    if (choice.charAt(0) == 'A') {
                        A.getCard(position).setPrice(price);
                    } else {
                        B.getCard(position).setPrice(price);
                    }

                    break;

                case 'G':
                    System.out.print("Enter a collection:");
                    choice = userInput.nextLine();

                    System.out.print("Enter a position:");
                    position = userInput.nextInt();

                    if (choice.charAt(0) == 'A')
                        A.getCard(position).toString();
                    else
                        B.getCard(position).toString();

                    break;
            }
        }while(Character.toUpperCase(looper[0]) != 'Q');
    }

    public static BaseballCard createCard(Scanner userInput)
    {
        String name = " ", manufacturer = " ";
        int year = 0;
        int X = 0, Y = 0;
        double price = 0.0;
        int position = 0;

        System.out.print("Enter the name:");
        name = userInput.nextLine();
        while(name.length() > 25){
            System.out.print("Name is too long, please enter a name that is less than 25 characters long: ");
            name = userInput.nextLine();
        }

        System.out.print("Enter the manufacturer:");
        manufacturer = userInput.nextLine();
        while(manufacturer.length() > 25){
            System.out.print("Name is too long, please enter a name that is less than 25 characters long: ");
            manufacturer = userInput.nextLine();
        }

        System.out.print("Enter the year:");
        year = userInput.nextInt();

        System.out.print("Enter the size:");
        X = userInput.nextInt();
        Y = userInput.nextInt();

        System.out.print("Enter the price:");
        price = userInput.nextDouble();
        while(price < 0){
            System.out.print("The price cannot be negative, try again:");
            price = userInput.nextDouble();
        }

        return new BaseballCard(name, manufacturer, year, price, X, Y);

    }

    public static void main(String[] args)
    {
        CardCollection A = new CardCollection();
        CardCollection B = new CardCollection();

        Scanner userInput = new Scanner(System.in);
        String choice = " ";
        char[] looper = new char[1];

        System.out.println("Main menu:");
        System.out.println("A) Add Card \nC) Copy \nE) Update price \nG) Get card \nL) Locate card \nN) Update name \nP) Print all cards \n" +
                "R) Remove card \nS) Size \nT) Trade \nV) Value of collections \nQ) Quit");


            choice(A,B,choice,userInput, looper);

    }
}
