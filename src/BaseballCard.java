/**
 * Nauman Shahzad
 * 109813732
 * Homework #1
 * Thursday: R04
 * Gustavo Poscidonio
 *
 * @author Nauman
 */
public class BaseballCard
{
    private String name;
    private String manufacturer;
    private int year;
    private double price;
    private int[] imageSize = new int[2];

    public BaseballCard() {}

    /**
     * Constructor with arguments for the class BaseballCard
     * @param name String data field to hold name
     * @param manufacturer String data field to hold manufacturer's name
     * @param year Int data field to hold what year it is
     * @param price Double data field to hold what the price is
     * @param sizeX Int argument passed for X value in imageSize
     * @param sizeY Int argument passed for Y value in imageSize
     * <dt><b>Postconditions:</b></dd> Creates a new Baseball Card.
     */
    public BaseballCard(String name, String manufacturer, int year, double price, int sizeX, int sizeY)
    {
        this.name = name;
        this.manufacturer = manufacturer;;
        this.year = year;
        this.price = price;
        this.imageSize[0] = sizeX;
        this.imageSize[1] = sizeY;
    }

    /**
     * Does a deep copy of a BasballCard object
     * @return returns a deep copy of this BaseballCard object
     * <dt><b>Postconditions:</b></dd> Creates a deep copy of the BaseballCard object
     */
    public Object clone()
    {
        BaseballCard objToBeCloned = new BaseballCard(this.getName(), this.getManufacturer(), this.getYear(), this.getPrice(), this.getImageSizeX(), this.getImageSizeY());
        return objToBeCloned;
    }

    /**
     * Compares two BaseballCards to see if contents in each are equivalent.
     * @param obj Object to be compared to this BaseballCard
     * @return Will return true or false if the two Objects are equal to each other
     * <dt><b>Postconditions:</b></dd> Returns true or false if the two objects are equal to each other.
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof BaseballCard)
        {
            BaseballCard objToCompare = new BaseballCard();
            objToCompare.setImageSizeX(((BaseballCard) obj).getImageSizeX());
            objToCompare.setImageSizeY(((BaseballCard) obj).getImageSizeY());
            objToCompare.setManufacturer(((BaseballCard) obj).getManufacturer());
            objToCompare.setName(((BaseballCard) obj).getName());
            objToCompare.setPrice(((BaseballCard) obj).getPrice());
            objToCompare.setYear(((BaseballCard) obj).getYear());

            if(objToCompare.getName().equals(this.name) && objToCompare.getManufacturer().equals(this.manufacturer) && objToCompare.getImageSizeX() == this.imageSize[0] &&
               objToCompare.getImageSizeY() == this.imageSize[1] && objToCompare.getPrice() == this.price && objToCompare.getYear() == this.year)
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        else
        {
            return false;
        }
    }

    /**
     * A getter method for String name data field.
     * @return Returns String name data field.
     */
    public String getName()
    {
        return name;
    }

    /**
     * A getter method for the String manufacturer data field.
     * @return Returns String manufacturer data field.
     */
    public String getManufacturer()
    {
        return manufacturer;
    }

    /**
     * A getter method for the int year data field.
     * @return Returns the int year data field.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * A getter method for the double price data field.
     * @return Returns the double price data field.
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * A getter method for the int sizeX element from imageSize.
     * @return Returns the int sizeX element form imageSize.
     */
    public int getImageSizeX()
    {
        return imageSize[0];
    }

    /**
     * A getter method for the int sizeY element from imageSize.
     * @return Returns the int sizeY element from imageSize.
     */
    public int getImageSizeY()
    {
        return imageSize[1];
    }

    /**
     * A setter method for the String name data field.
     * @param name Parameter passed is used to change the String name data field.
     * <dt><b>Postconditions:</b></dd> The String name data field is changed.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * A setter method for the String manufacturer data field.
     * @param manufacturer Parameter passed is used to change the String manufacturer data field.
     * <dt><b>Postconditions:</b></dd> The String manufacturer data field is changed.
     */
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    /**
     * A setter method for the int year data field.
     * @param year Parameter passed is used to change the int year data field.
     * <dt><b>Postconditions:</b></dd> The int year data field is changed.
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * A setter method for the double price data field.
     * @param price Parameter passed is used to change the double price data field.
     * <dt><b>Postconditions:</b></dt> The double price data field is changed.
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * A setter method to change the X size value in imageSize.
     * @param sizeX The parameter is used to change the X size value in imageSize.
     * <dt><b>Postconditions:</b></dd> The X value in imageSize is changed.
     */
    public void setImageSizeX(int sizeX)
    {
        this.imageSize[0] = sizeX;
    }

    /**
     * A setter method to change the Y size value in imageSize.
     * @param sizeY The parameter is used to change the Y size value in imageSize.
     * <dt><b>Postconditions:</b></dd> The Y value in imageSize is changed.
     */
    public void setImageSizeY(int sizeY)
    {
        this.imageSize[1] = sizeY;
    }

    public String toString()
    {
        String toPrint = String.format("%-21s%-26s%19s%06s%03s", "Name", "Manufacturer", "Year", "Price", "Size");
        toPrint += "\n" + String.format("%-21s%-26s%19d%06d%03d", name, manufacturer, year, price, imageSize[0]+"x"+imageSize[1]);

        return toPrint;
    }
}
