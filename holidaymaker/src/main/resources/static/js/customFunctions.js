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
            <a class="hotel" data-hotel-id="${hotel.hotelID}" data-hotel-name="${hotel.hotelName}">
                <div class="hotel-name">${hotel.hotelName}</div>
            </a>
        `;
        $('.result-hotels > .result-body').append(html);
    });
}

/**
*   Shows rooms in room display.
*
*   @param {String} hotelName
*   @param {Object} rooms - list containing rooms
*/
function displayHotelRooms(rooms, hotelName) {
    clearRoomDisplay();

    $('.room-sort').attr('data-hotel-id', rooms[0].hotelId);
    $.each(rooms, (key, room) => {
        let html = `
            <div class="room ${room.isBooked ? 'isBooked':''} flex-column flex-content-space-between flex-align-center" data-room-id="${room.roomId}" data-hotel-id="${room.hotelId}">
                <div class="room-select">${ room.isBooked ? '':`<a class="add-room" data-room-id="${room.roomId}" data-hotel-id="${room.hotelId}" data-hotel-name="${hotelName}"><i class="fas fa-plus"></i></a>` }</div>
                <div class="flex-column flex-content-space-between hotel-room-preview">
                    <div class="room-number">#${room.roomId}</div>
                    <div class="room-type">${room.roomType}</div>
                    <div class="room-price">${room.roomPrice}$</div>
                </div>
            </div>
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
*   @param {String} countryName
*   @return a Promise containing hotels
*/
function retrieveHotelsByCountry(countryName) {
    return new Promise((resolve, reject) => {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/hotels/country/'+countryName,
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
*   @param {String} countryName
*   @return a Promise containing hotels
*/
function retrieveHotelByName(hotelName) {
    return new Promise((resolve, reject) => {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/hotels/name/'+hotelName,
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
*   @param {Number} hotelId
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

/**
*   Ajax method to retrieve rooms sorted by price based on given sortAction
*
*   @param {Number} hotelId
*   @param {String} sortAction - <asc | desc>
*   @return a Promise containing hotel
*/
function retrieveHotelRoomsSorted(hotelId, sortAction) {
    console.log('/search/id/'+hotelId+'/price-'+sortAction);
    return new Promise((resolve, reject) => {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/search/id/'+hotelId+'/price-'+sortAction,
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
*
*/
function displayNewBooking(roomId, hotelName) {
    // update header
    $('.selected-room > .selected-room-info').html(`
        <span>${hotelName}</span>
        <span>Room #${roomId}</span>
    `);

    $('.selected-room-extras > form > input[name="roomId"]').val(roomId);

    // reset extras
    $('.selected-room input[type="checkbox"]').prop('checked', false)

    $('.selected-room').show();
}

function createNewBooking(formData) {
    return new Promise((resolve, reject) => {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url:'/bookings/post',
            type:'post',
            dataType:'json',
            data: formData,
            success: function(response) {
                resolve(response);
            },
            error: function(err) {
                resolve(err);
            }
        });
    });
}
