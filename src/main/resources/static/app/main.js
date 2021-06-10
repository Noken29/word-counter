class Text {
    constructor(content) {
        this.content = content
    }
}

async function submit() {
    var input = $.trim($('#input').val())
    console.log("Content : " + input)
    if (input != "") {
        var body = new Text(input)
        console.log(JSON.stringify(body))
        try {
            const response = await fetch('http://localhost:8080/api/text', {
              method: 'POST',
              body: JSON.stringify(body),
              headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8080/api/text',
                'Access-Control-Allow-Origin': 'http://localhost:8080/api/text',
                'Access-Control-Allow-Origin': 'origin',
                'Access-Control-Allow-Credentials': true,
                'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE',
                'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept, Authorization, Cache-Control, Pragma'
              },
            })
            const jsonBody = await response.json()
            console.log(jsonBody)
          } catch (error) {
            console.error('Error:', error);
          }
    }

}

