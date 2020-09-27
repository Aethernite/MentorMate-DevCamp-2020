import React from 'react';
//Styled Components
import styled from 'styled-components';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
//Bootstrap
import { Col, Navbar, Dropdown, Container } from 'react-bootstrap';
//React Router Dom
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { Search } from './UsersSearch'
import { placeholder, generateMediaUrl } from '../utilities';
import { logout } from '../store/slices/auth';

const Text = styled.span`
color: #FFF;
font-family: 'Lobster', cursive;
letter-spacing: 0.2rem;
font-size: 2rem;
`;

const Icon = styled.i`
transform: scale(1.5);
color: #fff;
transition: transform 0.2s;

&:hover{
    transform: scale(1.8);
    cursor: pointer;
}
`;


const IconCogWheel = styled.i`
transform: scale(1.5);
color: #fff;
transition: transform 0.2s;
&:hover{
    transform: rotate(90deg) scale(1.8);
    cursor: pointer;
}
`;

const Avatar = styled.img`
width: 40px;
height: 40px;
transition: transform 0.2s;
&:hover{
    transform: scale(1.2);
    cursor: pointer;
}
`;

const NavLink = styled(Link)`
display: inline-block;
font-family: 'Roboto', sans-serif;
font-weight: 300;
font-size: 1.5rem;
text-decoration: none;
color: #FFF;
transition: transform 0.2s;
padding: 0.5rem;
&:hover{
    color: #FFF;
    transform: scale(1.1);
}
`;


//NOTES:
// Faker mocks the avatar!!!
//
function NavigationBar() {

    const user = useSelector(state => state.auth.user);
    const dispatch = useDispatch();
    return (
        <Container fluid="xs" className="sticky-top">
            <Navbar bg="dark" >
                <Link to="/">
                    <Navbar.Brand>
                        <Text>Socify</Text>
                    </Navbar.Brand>
                </Link>
                {user && <Search />}
                <Col>
                    {user &&
                        <Dropdown className="float-right">
                            <Dropdown.Toggle as={Avatar} style={{ objectFit: 'cover' }} src={user.avatarId ? generateMediaUrl(user.avatarId) : placeholder} className="rounded-circle" />
                            <Dropdown.Menu>
                                <Dropdown.Item><Link to="/users/me" style={{ padding: '0px' }}>My Profile</Link></Dropdown.Item>
                                <Dropdown.Item><Link to="/login" onClick={() => dispatch(logout())} style={{ padding: '0px' }}>Sign out</Link></Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>}

                </Col>
                {user &&
                    <div>
                        <Icon className="fas fa-search ml-0 mr-3 d-inline-block d-sm-none" />
                        <Link to="/newsfeed" ><Icon className="fas fa-home ml-2 mr-3" /></Link>
                        <Icon className="fas fa-envelope ml-2 mr-3" />
                        <IconCogWheel className="fas fa-cog ml-2 mr-0" />
                    </div>
                }
                {!user &&
                    <div>
                        <NavLink className="nav-link" to="/">Login</NavLink>
                        <NavLink className="nav-link" to="/signup">Register</NavLink>
                    </div>
                }
            </Navbar>
        </Container>
    );
}

export default NavigationBar;