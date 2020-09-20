import React from 'react';
import styled from 'styled-components';
import PostHeaderDropdown from './PostHeaderDropdown';

const Header = styled.div`
padding: 16px;
margin: 0;
`;

function PostHeader({ post }) {
    return (
        <Header>
            <PostHeaderDropdown />
            <div className="media m-0">
                <div className="d-flex mr-3">
                    <a href="#AuthorProfile"><img className="img-fluid rounded-circle" src={post.authorAvatar} alt="User" /></a>
                </div>
                <div className="media-body">
                    <p className="m-0">{post.author}</p>
                    <small><span><i className="icon ion-md-pin"></i>{post.location}</span></small>
                    <small><span><i className="icon ion-md-time"></i>{post.timestamp}</span></small>
                </div>
            </div>
        </Header>
    );
}

export default PostHeader;
