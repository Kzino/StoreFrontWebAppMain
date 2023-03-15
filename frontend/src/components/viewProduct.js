import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Card from "react-bootstrap/Card";
import CardGroup from "react-bootstrap/CardGroup";
import Button from "react-bootstrap/Button";
import { loadImages } from "./loadImages";
import React, { useEffect, useState } from "react";
import { Link, useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import EditProduct from "./editProduct";

function ViewProduct() {
  const navigate = useNavigate();
  const { id } = useParams();
  const [product, setProduct] = useState();
  const [loader, setLoader] = useState(true);

  useEffect(() => {
    loadProduct(id);
  }, [id]);

  const loadProduct = async (id) => {
    console.log("ID stuff " + id);
    setLoader(true);
    const result = await axios.get("http://localhost:8081/view?id=" + id, {
      withCredentials: false,
    });
    setProduct(result.data);
    setLoader(false);
  };

  const deleteProduct = async () => {
    await axios.delete("http://localhost:8081/delete?id=" + id, {
      withCredentials: false,
    });
    navigate("/");
  };

  const editProduct = async () => {
    navigate("/edit/"+product.id)
  }

  return (
    <Container fluid>
      <Navbar bg="light" expand="">
        <Navbar.Brand>Store Front</Navbar.Brand>
      </Navbar>
      <Container>
        {loader ? (
          <Card.Text>Loading...</Card.Text>
        ) : (
          <CardGroup>
            <Card>
              <Card.Img style={{ width: '300px', height: '300px' }} variant="top" src={loadImages(product.productImg)} />
              <Card.Body>
                <Card.Title>{product.productName}</Card.Title>
                <Card.Text>Description: {product.productDescription}</Card.Text>
                <Card.Text>Price: £{product.productPrice}</Card.Text>
                <Card.Text>Category: {product.productCategory}</Card.Text>
                <Card.Text>Quantity: {product.productQuantity}</Card.Text>
              </Card.Body>
              <Button onClick={editProduct}>Edit Product</Button>
              <br />
              <Button onClick={deleteProduct} variant="danger">
                Delete Product
              </Button>
              {/* <Card.Footer>
                <small className="text-muted">Last updated ago</small>
                </Card.Footer> */}
            </Card>
          </CardGroup>
        )}
      </Container>
    </Container>
  );
}

export default ViewProduct;
