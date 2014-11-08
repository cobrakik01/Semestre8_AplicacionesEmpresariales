var nombreUsuario = "";
var inicioSecuencia = false;
spechDisponoble();
function spechDisponoble() {
    return window.SpeechRecognition || window.webkitSpeechRecognition;
}

function obtenerTexto( ) {
    if (spechDisponoble()) {
        // Obtenemos el objeto de reconocimento de texto de forma compatible a diferentes navegadores
        reconocimientoTexto = new (spechDisponoble())();
        reconocimientoTexto.onresult = function(event) {
            // Mostramos el texto obtenido
            var val = event.results[0][0].transcript;
            console.log(val);
            document.getElementById("salida").innerHTML = val;
            switch(val) {
                case "Prender":
                case "prender":
                    $.ajax({
                        url: 'PulsoServlet?senial=1',
                        type: 'get'
                    }).success(function(a, b, c){
                        meSpeak.speak("Prendido.", {});
                        console.log(a);
                    });
                break;
                case "Apagar":
                case "apagar":
                    $.ajax({
                        url: 'PulsoServlet?senial=0',
                        type: 'get'
                    }).success(function(a, b, c){
                        meSpeak.speak("Apagado.", {});
                        console.log(a);
                    });
                break;
                case "Iniciar":
                case "iniciar":
                    meSpeak.speak("Inicio de secuencia, ¿Cual es tu nombre?.", {});
                    inicioSecuencia = true;
                break;
                case "m1":
                case "M1":
                    meSpeak.speak(nombreUsuario + ", ya empese a ejecutar la secuencia m1.", {});
                break;
                case "m2":
                case "M2":
                    meSpeak.speak("ejecutando secuencia m2.", {});
                break;
                default:
                    if(inicioSecuencia) {
                        nombreUsuario = val;
                        meSpeak.speak("Bienbenido " + nombreUsuario, ", ¿Que quieres que haga?, solo recuerda que mis respuestas por ahora son limitadas.", {});
                    } else {
                        meSpeak.speak("Disculpa, pero no te entendi.", {});
                    }
                break;
            }
        }

        // Empezamos a reconocer texto
        reconocimientoTexto.start();
    }
}