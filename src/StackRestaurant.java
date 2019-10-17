import java.util.ArrayList;
/**
 * Implementation of the Restaurant abstract class. Stores and completes tickets based on a stack data structure.
 * Tickets are treated in a LIFO manner. That is, the last ticket (most recent) to be added to the restaurant is
 * the first ticket to be completed. This is in contrast to the QueueRestaurant which operates how a restaurant
 * normally would.
 * 
 * @author Kate McGeath 
 * @version 2018-10-15
 * 
 * Lab9
 */
public class StackRestaurant<T> extends Restaurant<T> {

	private static final int ORDER_LIST_SIZE = 10;
	private ArrayList<Order<T>> orderList;
	private int topOfStack;
	
    /**
     * Create the stack restaurant. Initializes the Order storage variables.
     */
	public StackRestaurant()
	{
		orderList = new ArrayList<Order<T>>(ORDER_LIST_SIZE);
	}
    /**
     * Add an order to the restaurant.
     * 
     * @param order The order to be added.
     * @return True. Because the StackRestaurant should resize if it runs out of room to store tickets, a ticket
     * should always be added, and this method should always return true.
     */
	@Override
	public boolean addOrder(Order<T> order)
	{
		orderList.add(order);
		topOfStack++;
		return true;
	}
    /**
     * [Internal Code - This is not required by the specification but can be a useful construct.]
     */
	@Override
	protected Order<T> completeOrder()
	{
		orderList.remove(topOfStack);
		topOfStack = topOfStack - 1;
		return orderList.get(topOfStack);
	}
    /**
     * Computes the number of orders in the restaurant that have not been completed.
     * 
     * @return the number of orders to complete.
     */
	@Override
	public int numberRemainingOrder()
	{
		return topOfStack;
	}
	
	@Override
	protected Order<T> checkNextCompletedOrder()
	{
		return orderList.get(topOfStack);
	}
}