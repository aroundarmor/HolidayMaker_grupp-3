package com.newton.holidaymaker.dto;

import java.io.Serializable;

public class UserBooking implements Serializable {
	private String hotelName;
	private int hotelId;
	private int roomId;
	private String roomType;
	private Double roomPrice;
	private long arrivalDate;
	private long departureDate;
	private boolean extraBed;
	private boolean twoMeals;
	private boolean threeMeals;
	private boolean allInclusive;

	public UserBooking(String hotelName, int hotelId, int roomId, String roomType, Double roomPrice, long arrivalDate, long departureDate, boolean extraBed, boolean twoMeals, boolean threeMeals, boolean allInclusive) {
		this.hotelName = hotelName;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;

		this.extraBed = extraBed;
		this.twoMeals = twoMeals;
		this.threeMeals = threeMeals;
		this.allInclusive = allInclusive;
	}

	public long getArrivalDate()   { return this.arrivalDate;   }
    public long getDepartureDate() { return this.departureDate; }

    public String getHotelName()         { return this.hotelName;     }
    public String getRoomType()          { return this.roomType;      }
    public Double getRoomPrice()         { return this.roomPrice;     }
    public int getHotelId()              { return this.hotelId;       }
    public int getRoomId()               { return this.roomId;        }
    public boolean getExtraBed()         { return this.extraBed;      }
    public boolean getTwoMeals()         { return this.twoMeals;      }
    public boolean getThreeMeals()       { return this.threeMeals;    }
    public boolean getAllInclusive()     { return this.allInclusive;  }

    public void setArrivalDate(long arrivalDate)       { this.arrivalDate = arrivalDate;     }
    public void setDepartureDate(long departureDate)   { this.departureDate = departureDate; }

    public void setHotelName(String hotelName)        { this.hotelName = hotelName;         }
    public void setRoomType(String roomType)          { this.roomType = roomType;           }
    public void setRoomPrice(Double roomPrice)        { this.roomPrice = roomPrice;         }
    public void setHotelId(int hotelId)               { this.hotelId = hotelId;             }
    public void setRoomId(int roomId)                 { this.roomId = roomId;               }
    public void setExtraBed(boolean extraBed)         { this.extraBed = extraBed;           }
    public void setTwoMeals(boolean twoMeals)         { this.twoMeals = twoMeals;           }
    public void setThreeMeals(boolean threeMeals)     { this.threeMeals = threeMeals;       }
    public void setAllInclusive(boolean allInclusive) { this.allInclusive = allInclusive;   }
}
