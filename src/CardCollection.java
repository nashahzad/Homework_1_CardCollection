/**
 * Nauman Shahzad
 * 109813732
 * Homework #1
 * Thursday: R04
 * Gustavo Poscidonio
 *
 * @author Nauman
 */
public class CardCollection
{
    private final int  MAX_CARDS = 100;
    private BaseballCard[] list = new BaseballCard[MAX_CARDS+1];

    /**
     * Creates a CardCollection object with on BaseballCard objects in it.
     * <dt><b>Postconditions:</b></dd> This CardCollection has been initialized with an empty list.
     */
    public CardCollection() {}

    /**
     * Determines how many BaseballCard objects are in the list
     * <dt><b>Preconditions:</b></dd> The CardCollection object needs to be instantiated
     * @return Returns the number of BaseballCard objects in the list
     */
    public int size() {
        int cardCount = 0;

        for (int x = 1; x < this.list.length; x++) {
            if (this.list[x] instanceof BaseballCard)
                cardCount++;
            else
                return cardCount;
        }

        return cardCount;
    }

    /**
     * Adds a BaseballCard to the list.
     * @param newCard The new Baseball Card to be added.
     * @param position The position in the list the card will be added in.
     * @throws IllegalArgumentException Exception to indicate that position is not in a valid range.
     * @throws Exception Exception to indicate there is no room left in the list.
     * <dt><b>Preconditions:</b></dd> This CardCollection object has been instantiated and 1 < position < items_currently_in_list + 1.
     * The number of BaseballCard objects in this Menu is less than MAX_CARDS.
     * <dt><b>Postconditions:</b></dd> The new card is added into the list. All cards that were originally in positions greater than or equal to position are moved back one position.
     */
    public void addCard(BaseballCard newCard, int position) throws IllegalArgumentException, Exception
    {
        if(position >= 1 && position <= size()+1)
        {
            if(this.list[MAX_CARDS] instanceof BaseballCard)
                throw new Exception("The list is full.");

            BaseballCard temp = new BaseballCard();
            for(int counter = position; counter < this.size()+1; counter++)
            {
                temp = this.list[counter+1];
                this.list[counter] = temp;
            }

            this.list[position] = newCard;

        }

        else
        {
            throw new IllegalArgumentException("The position is not valid. Try again:");
        }
    }

    /**
     * Works similarly to addCard method with two arguments, except the new card added is added to the end of the list.
     * @param newCard The new card to be added to end of the list.
     * <dt><b>Preconditions:</b></dd> This CardCollection object needs to be instantiated.
     * <dt><b>Postconditions:</b></dd> The new card is added to the end of the list.
     */
    public void addCard(BaseballCard newCard)
    {
        try
        {
            addCard(newCard, size());
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * A BaseballCard at the indicated position will be removed.
     * @param position The position in the list a card will be removed from.
     * <dt><b>Preconditions:</b></dd> The CardCollection is instantiated and the 1 <= position <= items_in_list.
     * <dt><b>Postconditions:</b></dt> The card at the desired position in the collection has been removed.
     * All cards that were originally in positions greater than or equal to position are moved forward one position.
     * @throws IllegalArgumentException An exception for when a position that is not in a valid range is passed.
     */
    public void removeCard(int position) throws IllegalArgumentException
    {
        if(position >= 1 && position <= size())
        {
            this.list[position] = null;
            BaseballCard temp = new BaseballCard();
            for(int counter = position-1; counter < size(); counter++)
            {
                temp = this.list[position+1];
                this.list[position] = temp;
            }
        }

        else
        {
            throw new IllegalArgumentException("The position is not within a valid range.");
        }
    }

    /**
     * Gets a BaseballCard at a given position in the CardCollection object.
     * @param position Position of the card to be retrieved
     * @return Returns the BaseballCard at the given position.
     * @throws IllegalArgumentException An exception for when a position that is not in a valid range is passed.
     * <dt><b>Preconditions:</b></dd> The CardCollection is instantiated and position is in a valid range.
     */
    public BaseballCard getCard(int position) throws IllegalArgumentException
    {
        if(position >= 1 && position <= size())
        {
            return this.list[position];
        }

        else
        {
            throw new IllegalArgumentException("The position is not within a valid range.");
        }
    }

    /**
     * A setter method to be utilized to set a BaseballCard at a specific position in the list.
     * @param element The element to placed into the list.
     * @param position The position in the list that the card will be added at.
     * @throws IllegalArgumentException An exception for when the position is not within a valid range.
     * <dt><b>Preconditions:</b></dd> The CardCollection is instantiated and position is in a valid range.
     * <dt><b>Postcondtions:</b></dd> The element at the specified location will be replaced with another element.
     */
    public void setListElement(BaseballCard element, int position) throws IllegalArgumentException
    {
        if(position >= 1 && position <= this.size())
        {
            this.list[position] = element;
        }

        else
        {
            throw new IllegalArgumentException("The position is not in a valid range.");
        }
    }

    /**
     * Exchanges a card from this collection for a card from another collection.
     * @param other The other CardCollection that we will be trading with.
     * @param myPosition Position in this CardCollection where the exchange will happen.
     * @param theirPosition The position in the other CardCollection where the exchange will happen
     * @throws IllegalArgumentException An exception for when either position is not in a valid range.
     * <dt><b>Preconditions:</b></dd> The CardCollection is instantiated and positions are in a valid range.
     * <dt><b>Postconditions:</b></dd> The cards will have been exchanged between both CardCollection objects at the specified positions.
     */
    public void trade(CardCollection other, int myPosition, int theirPosition) throws IllegalArgumentException
    {
        if((myPosition >= 1 &&  myPosition <= this.size()) && (theirPosition >= 1 && theirPosition <= other.size()))
        {
            BaseballCard temp = this.list[myPosition];
            this.list[myPosition] = other.getCard(theirPosition);
            other.setListElement(temp, theirPosition);
        }

        else
        {
            throw new IllegalArgumentException("One of the positions is not in a valid range.");
        }
    }

    /**
     * Checks to see if this card in the collection.
     * @param card The card we are looking for.
     * @return Returns whether or not the card exists.
     * <dt><b>Preconditions:</b></dd> The CardCollection is instantiated.
     */
    public boolean exists(BaseballCard card)
    {
        for(int counter = 1; counter <= this.size(); counter++)
        {
            if(this.list[counter].equals(card))
                return true;
        }

        return false;
    }

    public void printAllCards()
    {
        System.out.println(toString());
    }

    public String toString()
    {
        String toPrint = "";
        for(int counter = 1; counter <= size(); counter++)
        {
            toPrint += String.format("%-21s%-26s%19s%06d", this.list[counter].getName(), this.list[counter].getManufacturer(), this.list[counter].getYear(),
                                                           this.list[counter].getPrice());
            toPrint += this.list[counter].getImageSizeX() + "x" + this.list[counter].getImageSizeY() + "\n";
            toPrint = (counter+1) + ")" + toPrint;
        }

        return toPrint;
    }

}
