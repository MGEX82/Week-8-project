'use strict';

// Selectors

let resultsDiv = document.querySelector("#results");
let getBtn = document.querySelector("#get");
let postBtn = document.querySelector("#post");


// GET - READ
let getRequest = () => {
    axios.get("http://localhost:8080/user/getAll")
        .then((response) => {
            // console.log(response.data);
            displayResult(response.data);
        })
        .catch((err) => {
            console.error(err);
        });
}


// POST - CREATE
let postRequest = () => {

    let obj = {
        "year":"1950",
        "name":"Nino Farina",
        "nation":"Italy",
        "team":"Alfa Romeo"
    }

    axios.post("http://localhost:8080/user/create", obj)
        .then((response) => {
            console.log(response);
            // displayResult(response.data.data);
        })
        .catch((err) => {
            console.error(err);
        });
}
// PUT/PATCH - UPDATE

// DELETE - DELETE

let displayResult = (data) => {
    for (let entry of data) {
        const entryDiv = document.createElement("div");
        entryDiv.setAttribute("class", "entryDiv");
        const text = document.createTextNode(`ID: ${entry.id} | Year: ${entry.year} | Name: ${entry.Name} | Nation: ${entry.nation}| Team: ${entry.team}`);

        // const img = document.createElement("img");
        // img.setAttribute("src", entry.avatar);
        // img.setAttribute("class", "avatars");

        entryDiv.appendChild(text);
        resultsDiv.appendChild(entryDiv);
        // resultsDiv.appendChild(img);
    }
}

// Event Listeners
getBtn.addEventListener("click", getRequest);
postBtn.addEventListener("click", postRequest);
