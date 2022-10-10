<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<style type="text/css">
		#map {height: 600px; width: 100%;}
  		html, body {height: 100%;margin: 0;padding: 0; }
	</style>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container mt-3">
		<h2>Addres Ara</h2>
		<p>Enlem, Boylam ve Yarıçap bilgileri girilerek seçilen bölgedeki yerleri döndürür</p>
		<form class="mb-5 p-5 shadow border bg-light">
			<div class="row">
				<div class="col-4">
					<input type="text" class="form-control" placeholder="Enlem Gir" id ="latitude" name="latitude" value="40.9806745">
				</div>
				<div class="col-4">
					<input type="text" class="form-control" placeholder="Boylam Gir" id = "langitude" name="langitude" value="29.1031084">
				</div>
				<div class="col-3">
					<input type="text" class="form-control" placeholder="Yarıçap Gir" id="radius" value="1500">
				</div>
				<div class="col-1">
					<button id = "send" type="button" class="btn btn-primary" >Gönder</button>
				</div>
			</div>
		</form>
		<div id="map"></div>
	</div>
<div class="modal" id="error-modal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Uyarı</h4>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <p>Sistemde yaşanılan bir sıkıntıdan dolayı şuanda size cevap verememekterir lütfen tekrar deneyiniz</p>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Kapat</button>
      </div>

    </div>
  </div>
</div>

<div class="modal" id="info-modal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Uyarı</h4>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <p>Vermiş olduğunuz parametrelerde bir veri bulamadık</p>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Kapat</button>
      </div>

    </div>
  </div>
</div>


<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBlLZZRK-h8P8uXNzWnqI_wFNAXBcStxKE" ></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"> </script>
<script src="/js/app.js" defer></script>
</body>
</html>
