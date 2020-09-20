import React from 'react';
import styled from 'styled-components';

function PostHeaderDropdown() {

    const Button = styled.a`
    border-radius: 50%;
    font-size: 24px;
    height: 32px;
    width: 32px;
    padding: 0;
    overflow: hidden;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    `;

    const Dropdown = styled.div`
    position: relative;
    left: 13px !important;  
`;

    return (
        <Dropdown className="float-right">
            <Button type="button"><i className="fas fa-ellipsis-h" aria-hidden="true"></i></Button>
        </Dropdown>
    );
}

export default PostHeaderDropdown;
