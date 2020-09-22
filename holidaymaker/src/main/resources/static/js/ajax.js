$(document).ready(function() {
    console.log("JQuery Ready.");

    new Pikaday({ field: $('#arrivalDate')[0] });
    new Pikaday({ field: $('#departureDate')[0] });

    $('input#all').click(function() {
        let allInclusiveChecked = $(this).prop('checked');

        if(allInclusiveChecked === true) {
            $('input#extraBed').prop('checked', true);
            $('input#twoMeals').prop('checked', true);
            $('input#threeMeals').prop('checked', true);
        } else {
            $('input#extraBed').prop('checked', false);
            $('input#twoMeals').prop('checked', false);
            $('input#threeMeals').prop('checked', false);
        }
    });

    $('#book-room-form').submit(function(event) {
        event.preventDefault();

        // convert dates to integer
        const arrival   = new Date($('#arrivalDate').val()).getTime()   / 1000;
        const departure = new Date($('#departureDate').val()).getTime() / 1000;

        const extraBed   = $('input[name="extraBed"]').val()     == 0 ? false:true;
        const twoMeals   = $('input[name="twoMeals"]').val()     == 0 ? false:true;
        const threeMeals = $('input[name="threeMeals"]').val()   == 0 ? false:true;
        const all        = $('input[name="allInclusive"]').val() == 0 ? false:true;

        // put integer values of dates into JSON object
        let formData = {};
        formData['roomId'] = parseInt($('input[name="roomId"]').val());
        formData['arrivalDate'] = arrival;
        formData['departureDate'] = departure;
        formData['extraBed'] = extraBed;
        formData['twoMeals'] = twoMeals;
        formData['threeMeals'] = threeMeals;
        formData['allInclusive'] = all;

        // stringify and send to server
        createNewBooking(JSON.stringify(formData))
        .then((response) => {
            $('.new-booking-status').html('');

            if(response.message === 'invalidSession') {
                $('.new-booking-status').append(newAlertBox('warning', 'You need to be signed in.'));
            } else if (response.message === 'success') {
                $('.new-booking-status').append(newAlertBox('success', 'Booking successful.'));
            }
        })
        .catch((error) => {
            $('.new-booking-status').html('');
            $('.new-booking-status').append(newAlertBox('danger', 'Something went wrong, contact web admin.'));

           console.log("ERROR: " + error);
        });
    });

    $('.result-rooms .result-body').on('click', '.add-room', function() {
        if($(this).children('i').hasClass('fa-plus')) {
            $(this).html('<i class="fas fa-minus"></i>');

            let hotelName = $(this).attr('data-hotel-name');
            let roomId = $(this).attr('data-room-id');
            displayNewBooking(roomId, hotelName);

        } else {
            $(this).html('<i class="fas fa-plus"></i>');
        }
    });

    $('.room-sort').click(function() {
        let hotelId = parseInt($(this).attr('data-hotel-id'));
        let sortAction = $(this).attr('data-action');

        if(hotelId === NaN)
            return;

        retrieveHotelRoomsSorted(hotelId, sortAction)
        .then((rooms) => displayHotelRooms(rooms))
        .catch((err) => console.log(err));
    });

    // disable room filters by default
    // roomFilters('disabled');
    $('select.hotelCountry').change(function() {
        // clear room & hotel display before fetching new hotels
        clearHotelDisplay();
        clearRoomDisplay();

        let countryName = $(this).val();
        if(countryName === 'none') {
            console.log("val none");
            retrieveAllHotels()
            .then((hotels) => displayHotels(hotels))
            .catch((err)   => console.log("error: "+err));
        } else {
            retrieveHotelsByCountry(countryName)
            .then((hotels) => displayHotels(hotels))
            .catch((err)   => console.log("error: "+err));
        }
    });

    $('.result-hotels .result-body').on('click', 'a.hotel', function() {
        let hotelName = $(this).attr("data-hotel-name");
        retrieveAllHotelRoomsByHotelId($(this).attr('data-hotel-id')).
        then((rooms) => { displayHotelRooms(rooms, hotelName); });
    });

    /**
    *
    *   REGISTER FORM
    *
    */
    $('#registerForm').submit(function(event) {
        event.preventDefault();

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: '/register',
            type: 'post',
            data: getFormData($(this)),
            dataType: 'json',
            processData: false,
            contentType: false,
            success: function(response) {
                console.log(response.errors);
                // clear status box
                $('.register-status').html('');

                if(response.status == 'success') {
                    $('.register-status').append(newAlertBox('success', 'Your account has been created. Redirecting ...'));

                    // redirect user to login page
                    setTimeout(() => {
                        window.location.href ="/login";
                    }, 2000);

                } else {
                    // trim '[' and ']'
                    let errors = response.errors.substring(1, response.errors.length-1);

                    // e.g: "fname, lname, uname" ---> Array["fname", "lname", "uname"]
                    errors = errors.split(", ");

                    let errorMessages = "";

                    for (var i = 0; i < errors.length; i++) {
                        errorMessages += "<div>" + REGISTER_FORM_ERROR[errors[i]] + "</div>";
                    }

                    $('.register-status').append(newAlertBox('warning', errorMessages));
                }
            },

            error: function(err) {
                console.log(err);
            }
        });
    });

    /**
    *
    *   LOGIN FORM
    *
    */
    $('#loginForm').submit(function(event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: '/login',
            data: getFormData($('#loginForm')),
            cache: false,
            dataType: "json",
            crossDomain: false,
            success: function (data) {

                // clear status box
                $('.login-status').html('');

                if(data.status == "success") {
                    $('.login-status').append( newAlertBox('success', 'Login successful, you will soon be redirected ...') );

                    // redirect user in 2s
                    setTimeout(() => {
                        window.location.href = "/";
                    }, 2000);

                } else {
                    $('.login-status').prepend( newAlertBox('warning', 'Wrong username or password.') );
                }

            },
            error: function (data) {
                console.error("Internal Error");
            }
        });
    });
});
