function tpStartOnHourShowCallback(hour) {
    if (typeof endTimeWidget === 'undefined') {
        return false;
    }

    var tpEndHour = endTimeWidget.getHours();

    // Check if proposed hour is prior or equal to selected end time hour
    if (hour <= tpEndHour) {
        return true;
    }

    // if hour did not match, it can not be selected
    return false;
}

function tpStartOnMinuteShowCallback(hour, minute) {
    if (typeof endTimeWidget === 'undefined') {
        return false;
    }

    var tpEndHour = endTimeWidget.getHours();
    var tpEndMinute = endTimeWidget.getMinutes();

    // Check if proposed hour is prior to selected end time hour
    if (hour < tpEndHour) {
        return true;
    }

    // Check if proposed hour is equal to selected end time hour and minutes is prior
    if ((hour == tpEndHour) && (minute < tpEndMinute)) {
        return true;
    }

    // if minute did not match, it can not be selected
    return false;
}

function tpEndOnHourShowCallback(hour) {
    if (typeof startTimeWidget === 'undefined') {
        return false;
    }

    var tpStartHour = startTimeWidget.getHours();

    // Check if proposed hour is after or equal to selected start time hour
    if (hour >= tpStartHour) {
        return true;
    }

    // if hour did not match, it can not be selected
    return false;
}

function tpEndOnMinuteShowCallback(hour, minute) {
    if (typeof startTimeWidget === 'undefined') {
        return false;
    }

    var tpStartHour = startTimeWidget.getHours();
    var tpStartMinute = startTimeWidget.getMinutes();

    // Check if proposed hour is after selected start time hour
    if (hour > tpStartHour) {
        return true;
    }

    // Check if proposed hour is equal to selected start time hour and minutes is after
    if ((hour == tpStartHour) && (minute > tpStartMinute)) {
        return true;
    }

    // if minute did not match, it can not be selected
    return false;
}