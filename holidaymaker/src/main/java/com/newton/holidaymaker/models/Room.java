package com.newton.holidaymaker.models;

public class Room {
	private final long roomId;
	private final String roomType;
	private final long roomPrice;
	private final long hotelId;
	private final long bookingId;
	private final boolean isBooked;

	public Room(long roomId, String roomType, long roomPrice, long hotelId, long bookingId, boolean isBooked) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.hotelId = hotelId;
		this.bookingId = bookingId;
		this.isBooked = isBooked;
	}

	public long getRoomId() {
		return roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public long getRoomPrice() {
		return roomPrice;
	}

	public long getHotelId() {
		return hotelId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public boolean isBooked() {
		return isBooked;
	}
//problem with git
}
