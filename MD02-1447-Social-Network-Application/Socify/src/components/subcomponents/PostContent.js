import React from 'react';
import styled from 'styled-components';

const CardBoxItem = styled.div`
    display: block;
`;

function PostContent({ post }) {
    return (
        <CardBoxItem className="container fluid">
            <div className="view overlay zoom" style={{ margin: '0px', padding: '0px' }}>
                <img className="img-fluid w-100" src={post.contentImage} alt="Post Content" />
            </div>
        </CardBoxItem>
    );
}

export default PostContent;
