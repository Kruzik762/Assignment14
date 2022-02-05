let user = prompt("Enter a display name");
sessionStorage.getItem("user");

if (user === null) {
    displayName = prompt("Enter a screen name");    
    postToSpring(displayName);
} else {
    postToSpring(displayName);
}




function postToSpring(user) {
    fetch("/welcome/createUser", {
        method : "POST",
        headers : {"Content=Type" : "application/json"},
        body : user
    })
    .then(response => response.json())
    .then(user => sessionStorage.setItem("user", JSON.stringify(user)));
}