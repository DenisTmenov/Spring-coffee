<%@taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<div class="container margin-bottom">

	<c:if test="${not empty message}">
		<div class="col-xs-12">

			<div class="alert alert-success alert-dismissible" role="alert">

				<button type="button" class="close" data-dismiss="alert">&times;</button>

				${message}

			</div>

		</div>
	</c:if>

	<c:if test="${not empty messageError}">
		<div class="col-xs-12">

			<div class="alert alert-danger alert-dismissible" role="alert">

				<button type="button" class="close" data-dismiss="alert">&times;</button>

				${messageError}

			</div>

		</div>
	</c:if>

	<div class="row justify-content-center">

		<div class="col-md-offset-2 col-md-8 ">

			<div class="card card-primary">

				<div class="card-header text-center">


					<h4>Product Management</h4>

				</div>

				<div class="card-block">

					<springForm:form class="form-block" modelAttribute="product"
						action="${contextRoot}/manage/product" method="POST"
						enctype="multipart/form-data">

						<div class="form-group row dataTableFirstRow">
							<label for="productName-text-input" class="col-3 col-form-label ">Enter
								Product Name</label>
							<div class="col-9">
								<springForm:input class="form-control" type="text" path="name"
									id="productName-text-input" placeholder="New Product Name" />
								<div id="productName-error" class="form-control-feedback">Sorry,
									that Product Name's taken. Try another?</div>
								<springForm:errors path="name" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row dataTableFirstRow">
							<label for="brand-text-input" class="col-3 col-form-label ">Enter
								Brand Name</label>
							<div class="col-9">
								<springForm:input class="form-control" type="text" path="brand"
									id="brand-text-input" placeholder="Brand Name" />

								<springForm:errors path="brand" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="description-text-input" class="col-3 col-form-label ">Product
								Description</label>
							<div class="col-9">
								<springForm:textarea class="form-control" path="description"
									type="text" rows="4" placeholder="Description for new product"
									id="description-text-input" />

								<springForm:errors path="description" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="unitPrice-text-input" class="col-3 col-form-label ">Enter
								Unit Price</label>
							<div class="col-9">
								<springForm:input class="form-control" type="number"
									placeholder="30" path="unitPrice" id="unitPrice-text-input" />
								<springForm:errors path="unitPrice" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="quantity-text-input" class="col-3 col-form-label ">Quantity
								Available</label>
							<div class="col-9">
								<springForm:input class="form-control" type="number"
									placeholder="30" path="quantity" id="quantity-text-input" />
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="file-input" class="col-3 col-form-label ">Select
								Product Image:</label>
							<div class="col-9">
								<springForm:input class="form-control" type="file" path="file"
									id="file-input" />

								<springForm:errors path="file" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row dataTableBodyRow">
							<label for="active-choose" class="col-3 col-form-label">
								Status product: </label>
							<div class="col-9">
								<springForm:select class="custom-select col-9"
									id="active-choose" path="active">
									<option value=false selected>Disable</option>
									<option value=true>Active</option>
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

								<div class="text-right">
									<!-- Hidden fields for Category -->
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


	<div class="row justify-content-center ">
		<div class="col-md-12 ">
			<div class="card card-primary ">


				<div class="card-header text-center">


					<h3>Available Products</h3>
					<hr />
				</div>

				<div class="col-xs-12 ">

					<div style="overflow: auto">

						<!-- For Admin -->
						<table id="adminProductsTable"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>Id</th>
									<th>&#160;</th>
									<th>Name</th>
									<th>Quantity</th>
									<th>Unit Price</th>
									<th>Active</th>
									<th>Edit</th>
								</tr>
							</thead>

							<tbody>
								<tr>
									<td>4</td>
									<td><img class="adminDataTableImg"
										src="${contextRoot}/resources/image/PRDCOFFEE004.jpg"
										alt="Latte"></td>
									<td>Latte</td>
									<td>500</td>
									<td>&euro; 4.5</td>
									<td><label class="switch"> <input type="checkbox"
											checked="checked" value="4">
											<div class="slider round"></div>
									</label></td>
									<td><a href="${contextRoot}/manage/4/product"
										class="btn btn-warning"> <span class="fa fa-pencil"></span>
									</a></td>

								</tr>



								<tr>
									<td>4</td>
									<td><img class="adminDataTableImg"
										src="${contextRoot}/resources/image/PRDCOFFEE004.jpg"
										alt="Latte"></td>
									<td>Latte</td>
									<td>500</td>
									<td>&euro; 4.5</td>
									<td><label class="switch"> <input type="checkbox"
											value="4">
											<div class="slider round"></div>
									</label></td>
									<td><a href="${contextRoot}/manage/4/product"
										class="btn btn-warning"> <span class="fa fa-pencil"></span>
									</a></td>

								</tr>

							</tbody>

							<tfoot>
								<tr>
									<th>Id</th>
									<th>&#160;</th>
									<th>Name</th>
									<th>Quantity</th>
									<th>Unit Price</th>
									<th>Active</th>
									<th>Edit</th>
								</tr>
							</tfoot>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>