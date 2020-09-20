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
    @param {String} type <default | info | success | warning | danger>
    @param {String} msg
*/
function newAlertBox(type, msg) {
    let alertBox = $('<div></div>');
    let alertBoxMessage = $('<div class="alert-message">'+msg+'</div>');
//    let alertBoxClose = $('<div class="alert-close"><a>x</a></div>');

    alertBox.addClass('alert alert-'+type);
    alertBox.append(alertBoxMessage);
//    alertBox.append(alertBoxClose);

    return alertBox;
}
