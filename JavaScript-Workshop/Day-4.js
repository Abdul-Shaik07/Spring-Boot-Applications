let query = "list all the best ai's for generating pictures" 
async function chatgptclone(query){ 
    let response = await fetch('https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=AIzaSyDTQEgS2sf_TUXrIkR01w-3Bxnzymz5UtI',{ 
        method:"POST", 
        header:{"Content-Type": "application/json"}, 
        body:JSON.stringify({ 
            contents:[{parts:[{text:query}]}] 
        }) 
    }) 
        let data = await response.json() 
        console.log(data.candidates[0].content.parts[0].text) 
    } 
    chatgptclone(query)