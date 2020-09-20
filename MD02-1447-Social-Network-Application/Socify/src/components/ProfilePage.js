import React from 'react';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
//Bootstrap
import { Container } from 'react-bootstrap';
//Auth hook
import { useAuth } from '../contexts/AuthContext';

function Profile({ user }) {

    const { mockedUser } = useAuth();

    return (
        <Container style={{ paddingTop: '3%' }} fluid="xl">
            <img className="rela-block cover" src={mockedUser.cover} alt="Profile Cover" />
            <div className="rela-block profile-card">
                <img src={mockedUser.avatar} className="profile-pic" alt="Profile Avatar" />
                <div className="rela-block profile-name-container">
                    <div className="rela-block user-name" >{mockedUser.name}</div>
                    <div className="rela-block user-desc" >{mockedUser.description}</div>
                </div>
                <div className="rela-block profile-card-stats">
                    <div className="floated profile-stat liked" >{mockedUser.likes}<br /> Likes</div>
                    <div className="floated profile-stat followers" >{mockedUser.followers}<br /> Followers</div>
                    <div className="floated profile-stat following">{mockedUser.following}<br /> Following</div>
                </div>
            </div>
        </Container>
    );
}

export default Profile;