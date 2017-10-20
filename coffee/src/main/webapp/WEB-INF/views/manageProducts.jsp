<%@taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<div class="container margin-bottom">

	<div class="row justify-content-center">

		<div class="col-md-offset-2 col-md-8 ">

			<div class="card card-primary">

				<div class="card-header text-center">


					<h4>Product Management</h4>

				</div>

				<div class="card-block">

					<springForm:form class="form-block" modelAttribute="product">

						<div class="form-group row dataTableFirstRow">
							<label for="productName-text-input" class="col-3 col-form-label ">Enter
								Product Name</label>
							<div class="col-9">
								<springForm:input class="form-control" type="text" path="name"
									id="productName-text-input" placeholder="New Product Name"></springForm:input>
								<div id="productName-error" class="form-control-feedback">Sorry,
									that Product Name's taken. Try another?</div>
								<small id="productName-is-empty" class="form-text  help-block">
									Please enter Product Name!</small>
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="brand-select" class="col-3 col-form-label">
								Select Brand Name: </label>
							<div class="col-9">
								<springForm:select class="custom-select col-9" path="brand"
									id="brand-select" items="${brands}" itemLable="name"
									itemValue="id" />

								<small id="brand-is-empty" class="form-text help-block">
									Please enter Brand Name!</small>

								
							</div>


						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="description-text-input" class="col-3 col-form-label ">Product
								Description</label>
							<div class="col-9">
								<springForm:textarea class="form-control" path="description"
									type="text" rows="4" placeholder="Description for new product"
									id="description-text-input"></springForm:textarea>

								<small id="description-is-empty" class="form-text help-block">
									Please enter Product Description!</small>
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="unitPrice-text-input" class="col-3 col-form-label ">Enter
								Unit Price</label>
							<div class="col-9">
								<springForm:input class="form-control" type="number"
									placeholder="30" path="unitPrice" id="unitPrice-text-input"></springForm:input>
								<small id="unitPrice-is-empty" class="form-text help-block">
									Please enter Unit Price!</small>
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="quantity-text-input" class="col-3 col-form-label ">Quantity
								Available</label>
							<div class="col-9">
								<springForm:input class="form-control" type="number"
									placeholder="30" path="quantity" id="quantity-text-input"></springForm:input>
								<small id="quantity-is-empty" class="form-text help-block">
									Please enter Quantity Available!</small>
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="active-choose" class="col-3 col-form-label">
								Status product: </label>
							<div class="col-9">
								<springForm:select class="custom-select col-9"
									id="active-choose" path="active">
									<option value="disable" selected>Disable</option>
									<option value="active">Active</option>
								</springForm:select>
							</div>
						</div>


						<div class="form-group row dataTableBodyRow">
							<label for="categoryId" class="col-3 col-form-label">
								Select Category: </label>

							<div class="col-9">
								<springForm:select class="custom-select col-9" id="categoryId"
									path="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

								<small id="category-is-empty" class="form-text help-block">
									Please select Category!</small>
									
								<div class="text-right">
									<!-- Hidden fields for Product -->
									<springForm:hidden path="id" />
									<springForm:hidden path="code" />
									<springForm:hidden path="supplierId" />
									<springForm:hidden path="views" />
									<button type="button" class="btn btn-primary btn-xs"
										data-toggle="modal" data-target="#myCategoryModal">Add
										New Category</button>
								</div>
							</div>

						</div>

						<div class="form-group row dataTableLastRow">
							<div class="offset-sm-2 col-sm-10">
								<input type="submit" id="submit" name="submit"
									class="btn btn-primary" value="Submit">
							</div>
						</div>


					</springForm:form>



				</div>

			</div>




		</div>

	</div>
</div>

