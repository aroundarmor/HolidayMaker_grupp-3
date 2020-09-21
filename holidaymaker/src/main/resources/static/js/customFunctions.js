/**
    Parses form data into a JSON object
*/
function getFormData(element, excludeElements = null) {
    let formData = {};
    $.each(element.serializeArray(), function(key, obj) {
        // skip unwanted elements
        if(excludeElements != null)
            if(excludeElements.includes(obj.name))
                return true;

        formData[obj.name] = obj.value;
    });
    return JSON.stringify(formData);
}

/**
*   Generates an alertBox of <type> containing provided <msg>
*
*   @param {String} type <default | info | success | warning | danger>
*   @param {String} msg
*/
function newAlertBox(type, msg) {
    let alertBox = $('<div></div>');
    let alertBoxMessage = $('<div class="alert-message">'+msg+'</div>');
    alertBox.addClass('alert alert-'+type);
    alertBox.append(alertBoxMessage);
    return alertBox;
}

/**
*   Depending on given parameter 'mode',
*   enables or disables room filters.
*
*   @param {String} mode < enabled | disabled >
*/
function roomFilters(mode) {
    if(mode == 'enabled') {
        $('select.roomPriceOrder')  .attr('disabled', false);
        $('select.roomType')        .attr('disabled', false);
        $('select.roomAvailability').attr('disabled', false);
    } else {
        $('select.roomPriceOrder')  .attr('disabled', true).val('none').change();
        $('select.roomType')        .attr('disabled', true).val('none').change();
        $('select.roomAvailability').attr('disabled', true).val('none').change();
    }
}

/**
*   Shows hotels in hotel display.
*
*   @param {Object} hotels - list containing hotels
*/
function displayHotels(hotels) {
    clearHotelDisplay();

    $.each(hotels, (key, hotel) => {
        console.log(key, hotel.hotelName);
        let html = `
            <a class="hotel" data-hotel-id="${hotel.hotelID}">
                <div class="hotel-name">${hotel.hotelName}</div>
            </a>
        `;
        $('.result-hotels > .result-body').append(html);
    });
}

/**
*   Shows rooms in room display.
*
*   @param {Object} hotels - list containing hotels
*/
function displayHotelRooms(rooms) {
    clearRoomDisplay();

    $('.room-sort').attr('data-hotel-id', rooms[0].hotelId);
    $.each(rooms, (key, room) => {
        let html = `
            <a class="room flex-column flex-content-space-between" data-room-id="${room.roomId}" data-hotel-id="${room.hotelId}">
                <div class="room-number">${room.roomId}</div>
                <div class="room-type">${room.roomType}</div>
                <div class="room-price">${room.roomPrice}</div>
            </a>
        `;
        $('.result-rooms > .result-body').append(html);
    });
}

/**
*   Clears both hotel & room display
*   This is useful for when updating both displays.
*/
function clearHotelDisplay() {
    $('.result-hotels > .result-body').html('');
    $('.room-sort').attr('data-hotel-id', '');
}
function clearRoomDisplay()  {
    $('.result-rooms > .result-body').html('');
    $('.room-sort').attr('data-hotel-id', '');
}

/**
*   Ajax method to retrieve all hotels
*
*   @return a Promise containing hotels
*/
function retrieveAllHotels() {
    return new Promise((resolve, reject) => {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/hotels',
            type: 'get',
            dataType: 'json',
            success: function(response) {
                resolve(response);
            },
            error: function(err) {
                reject(err);
            }
        });
    });
}

/**
*   Ajax method to retrieve all hotels by country
*
*   @return a Promise containing hotels
*/
function retrieveHotelsByCountry(country) {
    return new Promise((resolve, reject) => {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/hotels/country/'+country,
            type: 'get',
            dataType: 'json',
            success: function(response) {
                resolve(response);
            },
            error: function(err) {
                reject(err);
            }
        });
    });
}

/**
*   Ajax method to retrieve all hotels by countryName
*
*   @return a Promise containing hotels
*/
function retrieveHotelByName(countryName) {
    return new Promise((resolve, reject) => {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/hotels/name/'+countryName,
            type: 'get',
            dataType: 'json',
            success: function(response) {
                resolve(response);
            },
            error: function(err) {
                resolve(err);
            }
        });
    });
}

/**
*   Ajax method to retrieve a specific hotel by given hotelId
*
*   @return a Promise containing hotel
*/
function retrieveAllHotelRoomsByHotelId(hotelId) {
    return new Promise((resolve, reject) => {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/rooms/hotelid/'+hotelId,
            type: 'get',
            dataType: 'json',
            success: function(response) {
                resolve(response);
            },
            error: function(err) {
                resolve(err);
            }
        });
    });
}
