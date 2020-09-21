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

/**
    Depending on given parameter 'mode',
    enables or disables room filters.
    @param {String} mode < enabled | disabled >
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
