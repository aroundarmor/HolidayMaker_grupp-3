$(document).ready(function() {

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
            success: function(response){
                console.log(response);
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
                console.log(data);
            },
            error: function (data) {
                console.error("Login failure");
            }
        });
    });


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
});
