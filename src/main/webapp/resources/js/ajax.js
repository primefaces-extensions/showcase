function ajaxOnStartIndicator() {
    document.body.style.cursor = 'wait';
    $("#ajaxIndicatorCaution").css("display", "none");
    $("#ajaxIndicatorActive").css("display", "block");

    // get the current counter
    var jqDoc = $(document);
    var requestCount = jqDoc.data("ajaxStatus.requestCount");
    if (typeof requestCount === 'undefined') {
        requestCount = 0;
    }

    // increase the counter
    jqDoc.data("ajaxStatus.requestCount", requestCount + 1);
}

function ajaxOnSuccessIndicator() {
    // get the current counter
    var jqDoc = $(document);
    var requestCount = jqDoc.data("ajaxStatus.requestCount");

    // check the counter
    if (typeof requestCount !== 'undefined') {
        if (requestCount == 1) {
            // hide indicators
            document.body.style.cursor = 'auto';
            $("#ajaxIndicatorActive").css("display", "none");
            $("#ajaxIndicatorCaution").css("display", "none");
            jqDoc.data("ajaxStatus.requestCount", 0);
        } else if (requestCount > 1) {
            // only decrease the counter
            jqDoc.data("ajaxStatus.requestCount", requestCount - 1);
        }
    }
}

function ajaxOnErrorIndicator() {
    document.body.style.cursor = 'auto';
    $("#ajaxIndicatorActive").css("display", "none");
    $("#ajaxIndicatorCaution").css("display", "block");
    // reset counter
    $(document).data("ajaxStatus.requestCount", 0);
}