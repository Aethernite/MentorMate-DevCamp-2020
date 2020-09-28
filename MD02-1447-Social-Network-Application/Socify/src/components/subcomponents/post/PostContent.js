import React from 'react';
import styled from 'styled-components';
import { generateMediaUrl } from '../../../utilities';

const CardBoxItem = styled.div`
    display: block;
`;

function PostContent({ post }) {
    return (
        <div>
            {
                post.mediaId &&
                <CardBoxItem className="container fluid">
                    <div className="view overlay zoom" style={{ margin: '0px', padding: '0px' }}>
                        <img className="img-fluid w-100" src={generateMediaUrl(post.mediaId)} alt="Post Content" />
                    </div>
                </CardBoxItem>
            }
        </div>
    );
}

export default PostContent;
