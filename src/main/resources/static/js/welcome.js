let user = sessionStorage.getItem("user");

if (user === null || user === "") {   
    let displayName = prompt("Enter a screen name");
    while (displayName === null || displayName === "" || displayName === " ") {
    displayName = prompt("Enter a screen name");
    }
    postToSpring(displayName);
} else {
    user = JSON.parse(sessionStorage.getItem("user"));
}

function postToSpring(displayName) {

    fetch("/welcome/createUser", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : displayName
    })
    .then(response => response.json())
    .then(user => sessionStorage.setItem("user", JSON.stringify(user))
    );
}

