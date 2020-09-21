$(document).ready(function() {
    console.log("JQuery Ready.");

    $('.room-sort').click(function() {
        let hotelId = parseInt($(this).data('hotel-id'));
        let sortAction = $(this).data('action');

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
        retrieveAllHotelRoomsByHotelId($(this).data('hotel-id')).
        then((rooms) => { displayHotelRooms(rooms); });
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
