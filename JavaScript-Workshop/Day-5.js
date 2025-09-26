


async function geminiApiResponse() {
    let input = document.querySelector("input").value;
let output = document.querySelector("div")
    let response = await fetch('https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=AIzaSyDTQEgS2sf_TUXrIkR01w-3Bxnzymz5UtI',{ 
        method:"POST", 
        header:{"Content-Type": "application/json"}, 
        body:JSON.stringify({ 
            contents:[{parts:[{text:input}]}] 
        }) 
    }) 
        let data = await response.json() 
        output.innerText = data.candidates[0].content.parts[0].text
    
}