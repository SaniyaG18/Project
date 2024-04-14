package com.bookstore.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book_table")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int bookId;
	
	@Column(name="Book_Title")
	private String bookTitle;
	
	@Column(name="Book_Author")
	private String bookAuthor;
	
	@Column(name="Book_Language")
	private String bookLanguage;
	
	@Column(name="Book_Availability")
	private boolean bookAvailability;
	
	@Column(name="Book_Price")
	private float bookPrice;
	
	@Column(name="Book_Rating")
	private float bookRating;

	@Column(name="Book_Publisher")
	private String bookPublisher;
	
	@Column(name="Book_PublicationDate")
	private Date publicationDate;
	
	 @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart; // Many books can be in one cart

}