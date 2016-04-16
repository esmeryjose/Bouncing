import java.awt.Graphics;


public interface CollectionInterface {
	
	public void add();
	// Adds the given Item to the collection.
	// That item becomes the item currently selected.

	public void remove();
	// Removes the selected item (if any).
	// No item is selected any more.

	public boolean isEmpty();
	//Returns if the array is empty


}
