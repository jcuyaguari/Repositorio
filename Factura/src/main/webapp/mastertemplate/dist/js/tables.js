$(function () {
    $("#example1").dataTable({
      "responsive": true,
      "autoWidth": false,
    });
    $('#example2').dataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });