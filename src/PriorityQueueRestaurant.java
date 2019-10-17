import java.util.PriorityQueue;

/**
 * @author Kate McGeath
 * @version 2018-10-17
 *
 * Lab 9
 * 
 * Restaurant class that stores orders in a PriorityQueue. This class uses the natural ordering of the Orders
 * (as defined by the Order compareTo() function) to determine which order should next be completed. Orders are sorted
 * by their stored timeOrdered, so the earliest order will be removed first. This is different from the
 * QueueRestaurant which will remove the order first inserted, regardless of what its time is.
 * 
 */
public class PriorityQueueRestaurant<T> extends Restaurant<T>
{
    private PriorityQueue<Order<T>> orderList;
    private int numOfOrders;

    public PriorityQueueRestaurant()
    {
    	orderList = new PriorityQueue<Order<T>>();
    }
    /**
     * Add an order to the restaurant. If there is no more room (number of tickets in the restaurant == maxSize of
     * queueRestaurant), do not add an order and return false.
     * 
     * @param order The Order to be added.
     * @return 
     */
    @Override
    public boolean addOrder(Order<T> order)
    {
    	orderList.add(order);
    	numOfOrders++;
    	return true;
    }
    /**
     * @return The next order to be removed.
     */
    @Override
    protected Order<T> completeOrder()
    {
    	return orderList.poll();
    }
    /**
     * Gets the number of orders stored.
     * @return The number of orders stored in the stack.
     */
    @Override
    protected int numberRemainingOrder()
    {
    	return orderList.size();
    }
    /**
     * Get the next order to be completed.
     * @return The order that will next be completed.
     */
    @Override
    public Order<T> checkNextCompletedOrder()
    {
    	return orderList.peek();
    }
}