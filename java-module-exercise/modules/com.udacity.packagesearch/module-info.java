module com.udacity.packagesearch {
	// Add your code here
	exports com.udacity.packagesearch.search.model;
	exports com.udacity.packagesearch.search.service;

	requires com.udacity.hotel;
	requires com.udacity.flight;
}