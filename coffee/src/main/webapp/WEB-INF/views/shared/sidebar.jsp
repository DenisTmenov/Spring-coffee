
<h1 class="my-4">Category</h1>
<div class="list-group">

	<c:forEach items="${category}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a>
	</c:forEach>
</div>