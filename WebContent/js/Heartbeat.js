var timeout = 30000; // 30 seconds
var intervalId;

function startHeartbeat() {
    intervalId = setInterval(checkHeartbeat, timeout);
}

function checkHeartbeat() {
    $.get("HeartbeatTimeoutServlet", function(data) {
        if (data != "OK") {
            clearInterval(intervalId);
            alert("Heartbeat timeout, please refresh the page.");
        }
    });
}
