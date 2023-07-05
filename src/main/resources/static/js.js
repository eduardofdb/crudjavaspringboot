function eliminar(idVentas) {
  swal({
    title: "¿Estás seguro de eliminar esta venta?",
    text: "Una vez eliminada, no podrás recuperar esta venta",
    icon: "warning",
    buttons: true,
    dangerMode: true,
  })
  .then((OK) => {
    if (OK) {
      $.ajax({
        url: "/ventas/eliminar/" + idVentas,
        success: function(res) {
          console.log(res);
          swal("¡La venta  ha sido eliminado!", {
            icon: "success",
          }).then((OK) => {
            if (OK) {
              location.href = "/ventas/listarcrud"; // Redirige a la ruta principal de ventas
            }
          });
        },
        error: function(xhr, status, error) {
          console.log(xhr.responseText);
          swal("Error", "Ha ocurrido un error al eliminar la venta", "error");
        }
      });
    } else {
      swal("¡venta segura has cancelado la eliminacion!");
    }
  });
}

