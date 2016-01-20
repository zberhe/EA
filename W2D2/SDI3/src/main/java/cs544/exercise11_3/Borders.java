/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.exercise11_3;

/**
 *
 * @author Zehafta M
 */
public class Borders  implements IBookSupplier{
  public double computePrice(String isbn) {
		double price = Math.random() * 45;
		System.out.println("Borders charges $" + price + " for book with isbn "
				+ isbn);
		return price;
	}

	public void order(Book book) {
		System.out.println("Book with isbn = " + book.getIsbn()
				+ " is ordered from Borders");
	}  
}
