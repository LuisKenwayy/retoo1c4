//--------Script Modulo User --------//

function postUser() {
  console.log("Ingreso a la funcion")
  if (
    $("#txtEmail").val().length == 0 ||
    $("#password-field").val().length == 0 ||
    $("#txtName").val().length == 0
  ) {
    alert("Todos los campos son obligatorios");
  } else {
    let varUser = {
      email: $("#txtEmail").val(),
      password: $("#password-field").val(),
      name: $("#txtName").val()
    };
    console.log(varUser);
    $.ajax({
      type: "POST",
      contentType: "application/json; charset=utf-8",
      dataType: "JSON",
      data: JSON.stringify(varUser),
      url: "http://localhost:57889/api/User/new",
      //url:"http://152.67.33.106:8080/api/Client/save",
      success: function (response) {
        console.log(response);
        alert("Usuario creado correctamente");
        window.location.reload();
      },
      error: function (jqXHR, textStatus, errorThrown) {
        window.location.reload();
        alert("No se creo el Usuario");
      },
    });
  }
}

function getUser() {
  $.ajax({
    url: "http://localhost:57889/api/User/all",
    //url:"http://152.67.33.106:8080/api/Client/all",
    type: "GET",
    datatype: "JSON",
    success: function (resultUser) {
      //console.log(resultUser);
      comprobar(resultUser);
    },
  });
}
function login() {

  console.log("Ingreso al  Login")
  if (
    $("#email").val().length == 0 ||
    $("#password-field").val().length == 0
  ) {
    alert("Todos los campos son obligatorios");
  } else {
    console.log("Datos obtenidos para guardar");
    getUser();
  }
}
function comprobar(resultUser) {
  let logEmail = $("#email").val();
  let logPass = $("#password-field").val();
  let dataEmail = "";
  let dataPass = "";
  console.log(logPass);

  for (i = 0; i < resultUser.length; i++) {
    dataEmail = resultUser[i].email;
    dataPass = resultUser[i].password;
    if (logEmail === dataEmail && logPass === dataPass) {
      console.log("Correcto "+dataEmail);
      redireccionar();
      let sesion = resultUser[i].name;
      return sesion;
    } else {
      console.log("Incorrecto "+dataEmail);
    }
  }
  function redireccionar() {
    window.location.href = "main.html";
  }
}
