class Text {
    constructor(content) {
        this.content = content
    }
}
function clearArea() {
    clearInput()
    clearOutput()
}
function clearInput() {
    $('#input').val('')
    $('#input').css('height', "65px");
}
function clearOutput() {
    $('#output').val('')
    $('#output').css('height', "65px");
}
async function submit() {
    var input = $.trim($('#input').val())
    clearOutput()
    console.log('Content : ' + input)
    if (input != "") {
        var body = new Text(input)
        $('#message').val('')
        if($("#isWillBeCleared").prop('checked'))
        {
            clearInput()
        }
        console.log('request: ', JSON.stringify(body))
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
            console.log('response: ', jsonBody)
            var result = jsonBody['result']
            var sortedResult = [];
            for (var word in result) {
                sortedResult.push([word, result[word]]);
            }
            sortedResult.sort(function(a, b) {
                return a[1] - b[1];
            });
            console.log('result: ', sortedResult)
            var i = 0;
            while (i < sortedResult.length) {
                $('#output').val($('#output').val() + sortedResult[i][0] + ' - ' + sortedResult[i][1] + '\n');
                i++;
            }
            $('#output').val($('#output').val() + 'Unique: ' + jsonBody['uniqueWords'])
            $('#output').autogrow()
          } catch (error) {
            console.error('Error:', error);
          }
    } else {
        alert('Input area is empty')
    }

}

