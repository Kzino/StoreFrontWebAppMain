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

function EditProduct() {
  const navigate = useNavigate();
  const { id } = useParams();
  const [product, setProduct] = useState();
  const [loader, setLoader] = useState(true);
  const [productName, setProductName] = useState("");
  const [productDescription, setproductDescription] = useState("");
  const [productPrice, setproductPrice] = useState("");
  const [productQuantity, setproductQuantity] = useState("");
  const [productCategory, setproductCategory] = useState("");
  const [productImg, setproductImg] = useState("");

  useEffect(() => {
    if (product) {
      setProductName(product.productName);
      setproductDescription(product.productDescription);
      setproductPrice(product.productPrice);
      setproductQuantity(product.productQuantity);
      setproductCategory(CategoryDropDown.find((i) => i.Category == product.productCategory));
      setproductImg(ImgDropDown.find((i) => i.Img == product.productImg));
    }
  }, [product]);

  const updateProduct = async () => {
    const result = await axios.patch(
      "http://localhost:8081/update",
      {
        id,
        productName,
        productDescription,
        productPrice,
        productQuantity,
        productCategory: productCategory.Category,
        productImg: productImg.Img,
      },
      { withCredentials: false }
    );
    navigate("/view/" + result.data.id);
  };

  useEffect(() => {
    loadProduct(id);
  }, [id]);

  const loadProduct = async (id) => {
    // console.log("ID stuff " + id);
    setLoader(true);
    const result = await axios.get("http://localhost:8081/view?id=" + id, {
      withCredentials: false,
    });
    setProduct(result.data);
    setLoader(false);
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

  const CategoryDropDown = [
    {
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
      {loader ? (
        <Container>
          <Card.Text>Loading...</Card.Text>
        </Container>
      ) : (
        <Container>
          <Row className="mb-3">
            <Form.Group as={Col} controlId="formGridProductName">
              <Form.Label>Product Name</Form.Label>
              <Form.Control
                defaultValue={productName}
                onChange={(e) => setProductName(e.target.value)}
                type="text"
                placeholder="Enter product name"
              />
            </Form.Group>
          </Row>
          <Row className="mb-3">
            <Dropdown>
              <Dropdown.Toggle variant="secondary" id="dropdown-basic">
                Select Product Image:{" "}
                {productImg?.Name || "No image is selected"}
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
                defaultValue={productPrice}
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
                defaultValue={productQuantity}
                onChange={(e) => setproductQuantity(e.target.value)}
                type="text"
                placeholder="Enter product quantity"
              />
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Dropdown>
              <Dropdown.Toggle variant="primary" id="dropdown-basic">
                Select Product Category:{" "}
                {productCategory?.Category || "No product category is selected"}
              </Dropdown.Toggle>
              <Dropdown.Menu>
                {CategoryDropDown.map((item, index) => (
                  <DropdownItem
                    key={index}
                    onClick={() => setproductCategory(item)}
                  >
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
                defaultValue={productDescription}
                onChange={(e) => setproductDescription(e.target.value)}
                as="textarea"
                placeholder="Describe the product"
              />
            </Form.Group>
          </Row>
          <br />
          <br />
          <Button onClick={() => updateProduct()} type="submit">
            Update
          </Button>
        </Container>
      )}
    </Container>
  );
}

export default EditProduct;
