var $loading = $("<div class='loading'><p>Loading more items...</p></div>");

function handleWaypoint(ext) {
    if (ext.direction == "down") {
        ext.target.waypoint('remove');
        $('body').append($loading);

        console.log("Load...");

        $('#container').append("<div class='article'>" + "<h2>Vestibulum</h2>" + "<p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros" + "eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus," + "metus sit amet est et sapien ullamcorper pharetra. Aliquam erat volutpat. Nam dui mi, tincidunt" + "quis, accumsan porttitor, facilisis luctus. Hello said dkrew qwq ncki juewewe, upsum el.</p>" + "</div>");

        $loading.detach();
        delete ext.cfg.handler;
        ext.target.waypoint(ext.cfg);
    }
}
