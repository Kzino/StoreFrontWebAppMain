import Container from "react-bootstrap/Container";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Card from "react-bootstrap/Card";
import CardGroup from "react-bootstrap/CardGroup";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import FloatingLabel from "react-bootstrap/FloatingLabel";
import Dropdown from "react-bootstrap/Dropdown";
import axios from "axios";
import React, { useState, useEffect } from "react";
import DropdownItem from "react-bootstrap/esm/DropdownItem";
import { Link, useParams, useNavigate } from "react-router-dom";

function AddProduct() {
  const navigate = useNavigate();
  const [productName, setProductName] = useState("");
  const [productDescription, setproductDescription] = useState("");
  const [productPrice, setproductPrice] = useState("");
  const [productQuantity, setproductQuantity] = useState("");
  const [productCategory, setproductCategory] = useState("");
  const [productImg, setproductImg] = useState("");

  const postProducts = async () => {
    const result = await axios.post(
      "http://localhost:8081/add",
      {
        productName,
        productDescription,
        productPrice,
        productQuantity,
        productCategory : productCategory.Category,
        productImg: productImg.Img,
      },
      { withCredentials: false }
    );
    navigate("/view/"+result.data.id);
  };

  const ImgDropDown = [
    {
      Name: "Mug",
      Img: "Version1Mug.png",
    },

    {
      Name: "Bottle",
      Img: "Version1Bottle.png",
    },

    {
      Name: "T-shirt",
      Img: "Version1tshirt.png",
    },

    {
      Name: "Tote bag",
      Img: "Version1ToteBag.png",
    },

    {
      Name: "Notepad",
      Img: "Version1Notepad.png",
    },
  ];

  const CategoryDropDown = [{
    Category: "Stationery",
    
  },

  {
    Category: "Accessories",
  },

];

  return (
    <Container fluid>
      <Navbar bg="light" expand="">
        <Navbar.Brand>Store Front</Navbar.Brand>
      </Navbar>

      <Container>
        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridProductName">
            <Form.Label>Product Name</Form.Label>
            <Form.Control
              onChange={(e) => setProductName(e.target.value)}
              type="text"
              placeholder="Enter product name"
            />
          </Form.Group>
        </Row>
      

        <Row className="mb-3">
          <Dropdown>
            <Dropdown.Toggle variant="secondary" id="dropdown-basic">
              Select Product Image: {productImg?.Name || "No image is selected"} 
            </Dropdown.Toggle>

            <Dropdown.Menu>
              {ImgDropDown.map((item, index) => (
                <DropdownItem key={index} onClick={() => setproductImg(item)}>
                  {item.Name}
                </DropdownItem>
              ))}
            </Dropdown.Menu>
          </Dropdown>
        </Row>

        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridProductPrice">
            <Form.Label>Product Price</Form.Label>
            <Form.Control
              onChange={(e) => setproductPrice(e.target.value)}
              type="text"
              placeholder="Enter product price"
            />
          </Form.Group>
        </Row>

        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridProductQuantity">
            <Form.Label>Product Quantity</Form.Label>
            <Form.Control
              onChange={(e) => setproductQuantity(e.target.value)}
              type="text"
              placeholder="Enter product quantity"
            />
          </Form.Group>
        </Row>

        <Row className="mb-3">
          {/* <Form.Group as={Col} controlId="formGridProductCategory">
            <Form.Label>Product Category</Form.Label>
            <Form.Control type="text" placeholder="Enter product category" />
            </Form.Group> */}
          <Dropdown>
            <Dropdown.Toggle variant="primary" id="dropdown-basic">
              Select Product Category: {productCategory?.Category || "No product category is selected"}
            </Dropdown.Toggle>

            <Dropdown.Menu>
              {CategoryDropDown.map((item, index) => (
                <DropdownItem key={index} onClick={() => setproductCategory(item)}>
                  {item.Category}
                </DropdownItem>
              ))}
            </Dropdown.Menu>
          </Dropdown>
        </Row>

        <Row className="mb-3">
          <Form.Group as={Col} controlId="formGridProductDescription">
            <Form.Label>Product Description</Form.Label>
            <Form.Control
              onChange={(e) => setproductDescription(e.target.value)}
              as="textarea"
              placeholder="Describe the product"
            />
          </Form.Group>
        </Row>
        <br />
        <br />
        <Button onClick={() => postProducts()} type="submit">
          Submit
        </Button>
      </Container>
    </Container>
  );
}

export default AddProduct;
