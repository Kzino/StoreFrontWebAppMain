import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import Card from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Button from 'react-bootstrap/Button';
import axios from 'axios';
import React, { useState, useEffect } from "react";
import { BrowserRouter, Route, Routes, useNavigate } from "react-router-dom";
import { loadImages } from './loadImages';
function Home() {
    

    const [products, setProducts] = useState([]);
    

    useEffect(() => {
        loadProducts();
    },[]);

    const loadProducts = async () => {
        const result = await axios.get("http://localhost:8081/list", {withCredentials:false})
        setProducts(result.data);
    }

    const navigate = useNavigate();

    // const handleClick() {

    // }
   



  return ( 
    <Container fluid>
        <Navbar bg="light" expand="">
            <Navbar.Brand>Store Front</Navbar.Brand>
        </Navbar>

    <Container>
    <CardGroup>
            {products.map((item, index) => (
            <Card style={{ width: '300px', height: '300px' }} key={index}>
                <Card.Img style={{ width: '300px', height: '300px' }} variant="top" src={loadImages(item.productImg)} />
                <Card.Body>
                <Card.Title>{item.productName}</Card.Title>
                <Card.Text>
                    Description: {item.productDescription}
                </Card.Text>
                <Card.Text>
                   Price: £{item.productPrice}
                </Card.Text>
                <Card.Text>
                    Category: {item.productCategory}
                </Card.Text>
                <Card.Text>
                    Quantity: {item.productQuantity}
                </Card.Text>
                </Card.Body>

                <Button onClick={() => navigate("/view/"+item.id)}>View Product</Button>
                <Card.Footer>
                
                </Card.Footer>
            </Card>
                ))}
            <br />
            <br />
            {/* <Card>
                <Card.Img variant="top" src={require('../assets/Version1ToteBag.png')} />
                <Card.Body>
                <Card.Title>Tote Bag</Card.Title>
                <Card.Text>
                    Description: Tote Bag for your grocery shopping
                </Card.Text>
                <Card.Text>
                    Price: £5.00
                </Card.Text>
                <Card.Text>
                    Cateory: Accessories
                </Card.Text>
                <Card.Text>
                    Quantity: 5
                </Card.Text>
                </Card.Body>
                <Button>View Product</Button>
                <Card.Footer>
                <small className="text-muted">Last updated ago</small>
                </Card.Footer>
            </Card>
            <br />
            <br /> */}
            {/* <Card>
                <Card.Img variant="top" src={require('../assets/Version1Mug.png')} />
                <Card.Body>
                <Card.Title>Mug</Card.Title>
                <Card.Text>
                    Description: Mug to drink your hot tea or coffee.
                </Card.Text>
                <Card.Text>
                    Price: £7.00
                </Card.Text>
                <Card.Text>
                    Cateory: Accessories
                </Card.Text>
                <Card.Text>
                    Quantity: 20
                </Card.Text>
                </Card.Body>
                <Button>View Product</Button>
                <Card.Footer>
                <small className="text-muted">Last updated ago</small>
                </Card.Footer>
            </Card>
            <br />
            <br /> */}
        {/* </CardGroup>  */}

        {/* <CardGroup>
            <Card>
                <Card.Img variant="top" src={require('../assets/Version1Bottle.png')} />
                <Card.Body>
                <Card.Title>Bottle</Card.Title>
                <Card.Text>
                    Description: Bottle to keep your drink nice and cool!
                </Card.Text>
                <Card.Text>
                    Price: £10.00
                </Card.Text>
                <Card.Text>
                    Cateory: Accessories
                </Card.Text>
                <Card.Text>
                    Quantity: 10
                </Card.Text>
                </Card.Body>
                <Button>View Product</Button>
                <Card.Footer>
                <small className="text-muted">Last updated ago</small>
                </Card.Footer>
            </Card>
            <br />
            <br />
            <Card>
                <Card.Img variant="top" src={require('../assets/Version1Notepad.png')} />
                <Card.Body>
                <Card.Title>Notepad</Card.Title>
                <Card.Text>
                    Description: Notepad to keep track of your important notes and secrets shhh
                </Card.Text>
                <Card.Text>
                    Price: £6.00
                </Card.Text>
                <Card.Text>
                    Cateory: Stationery
                </Card.Text>
                <Card.Text>
                    Quantity: 3
                </Card.Text>
                </Card.Body>
                <Button>View Product</Button>
                <Card.Footer>
                <small className="text-muted">Last updated ago</small>
                </Card.Footer>
            </Card>
            <br />
            <br />
            <Card>
                <Card.Img variant="top" src={require('../assets/Version1tshirt.png')} />
                <Card.Body>
                <Card.Title>T-shirt</Card.Title>
                <Card.Text>
                    Description: T-shirt to wear and feel awesome whilst representing the Version 1 company.
                </Card.Text>
                <Card.Text>
                    Price: £10.00
                </Card.Text>
                <Card.Text>
                    Cateory: Accessories
                </Card.Text>
                <Card.Text>
                    Quantity: 3
                </Card.Text>
                </Card.Body>
                <Button>View Product</Button>
                <Card.Footer>
                <small className="text-muted">Last updated ago</small>
                </Card.Footer>
            </Card> */}
        </CardGroup> 

            </Container> 
        </Container>
    
    );
}

export default Home;