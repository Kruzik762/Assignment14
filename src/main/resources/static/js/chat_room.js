let user = sessionStorage.getItem("user");

if (user === null || user === "") {
   window.location.replace("/welcome");    
} else {
    user = JSON.parse(sessionStorage.getItem("user"));
}

user = JSON.parse(sessionStorage.getItem("user"));
let chatBox = document.getElementById("chatBox");
let messageInputBox = document.getElementById("messageInputBox");
let messageInputButton = document.getElementById("messageInputButton");
let userId = user.userId;
console.log(userId)
let senderName = user.name;
console.log(senderName);
let url = window.location.href;
let channelId = url.substring(url.lastIndexOf("/") + 1, url.length);
console.log(channelId);


messageInputBox.addEventListener("keypress", submitMessage);
messageInputButton.addEventListener("click", submitMessage);
setInterval(getMessages, 500);
// messageInputButton.addEventListener("onclick", () =>  console.log("Button pressed"));

function submitMessage(event) {
    if (event.keyCode === 13 || event.type === "click") {
        var message = {
            senderName : senderName,
            messageContent : messageInputBox.value,
            channelId : channelId,
            userId : userId
        }       
        messageInputBox.value = "";
        fetch(`/channels/${channelId}/createMessage`, {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(message)
        }).then( () => getMessages())
        // .then(response => console.log(response))
       
    } else {
        return false;
    }
}


function getMessages() {
    fetch(`/channels/${channelId}/getMessages`, {   
        method : "POST",
        headers : {"Content-Type" : "application/json"}
    })
    .then(response => response.json())
    .then( (data) => populateMessages(data))

}

function populateMessages(data) {
    console.log(data);
    let chatBox = document.getElementById("chatBox");
    chatBox.innerHTML = "";    


    for (let i = 0; i < data.length; i++) {              
        chatBox.textContent += `<${data[i].senderName}> ${data[i].messageContent} \n`
    }
}