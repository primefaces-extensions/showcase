function tpStartOnHourShowCallback(hour) {
    if (typeof endTimeWidget === 'undefined') {
        return false;
    }

    var tpEndHour = parseInt(endTimeWidget.getHours());

    // Check if proposed hour is prior or equal to selected end time hour
    if (parseInt(hour) <= tpEndHour) {
        return true;
    }

    // if hour did not match, it can not be selected
    return false;
}

function tpStartOnMinuteShowCallback(hour, minute) {
    if (typeof endTimeWidget === 'undefined') {
        return false;
    }

    var tpEndHour = parseInt(endTimeWidget.getHours());
    var tpEndMinute = parseInt(endTimeWidget.getMinutes());

    // Check if proposed hour is prior to selected end time hour
    if (parseInt(hour) < tpEndHour) {
        return true;
    }

    // Check if proposed hour is equal to selected end time hour and minutes is prior
    if ((parseInt(hour) == tpEndHour) && (parseInt(minute) < tpEndMinute)) {
        return true;
    }

    // if minute did not match, it can not be selected
    return false;
}

function tpEndOnHourShowCallback(hour) {
    if (typeof startTimeWidget === 'undefined') {
        return false;
    }

    var tpStartHour = parseInt(startTimeWidget.getHours());

    // Check if proposed hour is after or equal to selected start time hour
    if (parseInt(hour) >= tpStartHour) {
        return true;
    }

    // if hour did not match, it can not be selected
    return false;
}

function tpEndOnMinuteShowCallback(hour, minute) {
    if (typeof startTimeWidget === 'undefined') {
        return false;
    }

    var tpStartHour = parseInt(startTimeWidget.getHours());
    var tpStartMinute = parseInt(startTimeWidget.getMinutes());

    // Check if proposed hour is after selected start time hour
    if (parseInt(hour) > tpStartHour) {
        return true;
    }

    // Check if proposed hour is equal to selected start time hour and minutes is after
    if ((parseInt(hour) == tpStartHour) && (parseInt(minute) > tpStartMinute)) {
        return true;
    }

    // if minute did not match, it can not be selected
    return false;
}
