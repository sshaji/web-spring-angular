(function() {
	templates = {

		offer_list_template : '\
			<a class="btn btn-primary" href="#/new">Create New</a>\
			<table class="table table-striped">\
				<thead>\
					<tr>\
						<th>Id</th>\
						<th>Name</th>\
						<th>Email</th>\
						<th>Offer</th>\
						<th></th>\
					</tr>\
				</thead>\
				<tbody>\
					<@ _.each(rc.offers, function(offer) { @>\
					<tr>\
						<td><@= offer.get("id") @></td>\
						<td><@= offer.get("name") @></td>\
						<td><@= offer.get("email") @></td>\
						<td><@= offer.get("offerDetails") @></td>\
						<td><a class="btn btn-info btn-sm" href="#/edit/<@= offer.get("id") @>">Edit</a></td>\
					</tr>\
					<@ }); @>\
				</tbody>\
			</table>\
		',

		edit_offer_template : '\
			<form class="edit-user-form">\
				<legend><@= rc.offer ? "Edit" : "New" @> Offer</legend>\
				<label>Name</label>\
				<input name="name" type="text" value="<@= rc.offer ? rc.offer.get("name") : "" @>" class="form-control">\
				<label>Email</label>\
				<input name="email" type="text" value="<@= rc.offer ? rc.offer.get("email") : "" @>" class="form-control">\
				<label>Offer</label>\
				<input name="offerDetails" type="text" value="<@= rc.offer ? rc.offer.get("offerDetails") : "" @>" class="form-control">\
				<hr />\
				<button type="submit" class="btn btn-success"><@= rc.offer ? "Update" : "Create" @></button>\
				<@ if (rc.offer) { @>\
					<input type="hidden" name="id" value="<@= rc.offer ? rc.offer.get("id") : "" @>">\
					<button class="btn btn-danger delete">Delete</button>\
				<@ } @>\
			</form>\
		'

	};
})();